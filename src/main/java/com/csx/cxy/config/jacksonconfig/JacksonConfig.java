package com.csx.cxy.config.jacksonconfig;

import com.csx.cxy.config.jacksonconfig.NullValueSerializer;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;

@Configuration
public class JacksonConfig {

    @Value("yyyy-MM-dd HH:mm:ss")
    private String pattern;


    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        // 禁用将日期序列化为时间戳
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        // 设置日期时间格式
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        objectMapper.setDateFormat(dateFormat);

        // 注册 JavaTimeModule，支持对 Java 8 时间日期类型的序列化和反序列化
        objectMapper.registerModule(new JavaTimeModule());

        // 注册全局 LocalDateTime 序列化器
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        objectMapper.registerModule(new SimpleModule()
                .addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(formatter)));


        // 处理集合、数组、字符串、数值、布尔值
        objectMapper.setSerializerFactory(objectMapper.getSerializerFactory()
                        .withSerializerModifier(new BeanSerializerModifier(){
                        @Override
                        public List<BeanPropertyWriter> changeProperties(SerializationConfig config,
                                                                         BeanDescription beanDesc,
                                                                         List<BeanPropertyWriter> beanProperties) {

                            for (BeanPropertyWriter writer : beanProperties) {
                                Class<?> clazz = writer.getType().getRawClass();
                                if (clazz.isArray() || Collection.class.isAssignableFrom(clazz)) {
                                    // 集合或数组处理
                                    writer.assignNullSerializer(new NullValueSerializer.NullArrayJsonSerializer());
                                }else if(CharSequence.class.isAssignableFrom(clazz) || Character.class.isAssignableFrom(clazz)) {
                                    // 字符串
                                    writer.assignNullSerializer(new NullValueSerializer.NullStringJsonSerializer());
                                }else if(Boolean.class.equals(clazz)) {
                                    // 布尔值
                                    writer.assignNullSerializer(new NullValueSerializer.NullBooleanJsonSerializer());
                                }else if(Number.class.isAssignableFrom(clazz)) {
                                    // 数值
                                    writer.assignNullSerializer(new NullValueSerializer.NullNumberJsonSerializer());
                                }
                            }
                            return beanProperties;
                        }
                }));

        // 处理null对象
        objectMapper.getSerializerProvider().setNullValueSerializer(new NullValueSerializer.NullObjectJsonSerializer());

        return objectMapper;
    }



}
