package com.csx.cxy.aop;


import cn.hutool.extra.servlet.ServletUtil;
import com.csx.cxy.annotation.NoRepeatSubmit;
import com.csx.cxy.common.R;
import com.csx.cxy.constants.HeaderConstant;
import com.csx.cxy.constants.RedisConstant;
import com.csx.cxy.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Objects;

@Slf4j
@Aspect
@Component
public class NoRepeatSubmitAop {

    @Autowired
    private RedisUtil redisUtil;

    @Around("execution(* com.csx.cxy.controller.*Controller.*(..)) && @annotation(noRepeatSubmit)")
    public Object doAround(ProceedingJoinPoint pjp, NoRepeatSubmit noRepeatSubmit) {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();

            // 拿到ip地址、请求路径、token
            String ip = ServletUtil.getClientIP(request);
            String url = request.getRequestURL().toString();
            String token = request.getHeader(HeaderConstant.REQUEST_HEADERS_TOKEN);

            // 现在时间
            long now = System.currentTimeMillis();

            // 自定义key值方式
            String key = RedisConstant.REQUEST_FROM + ip;
            if (redisUtil.hasKey(key)) {
                // 上次表单提交时间
                long lastTime = Long.parseLong(redisUtil.get(key));
                // 如果现在距离上次提交时间小于设置的默认时间 则 判断为重复提交  否则 正常提交 -> 进入业务处理
                if ((now - lastTime) > noRepeatSubmit.time()) {
                    // 非重复提交操作 - 重新记录操作时间
                    redisUtil.set(key, String.valueOf(now));
                    // 进入处理业务
                    return pjp.proceed();
                } else {
                    return R.SUCCESS("请勿重复提交!");
                }
            } else {
                // 这里是第一次操作
                redisUtil.set(key, String.valueOf(now));
                return pjp.proceed();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }


}
