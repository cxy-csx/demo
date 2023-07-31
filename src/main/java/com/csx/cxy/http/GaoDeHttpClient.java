package com.csx.cxy.http;

import com.dtflys.forest.annotation.DataVariable;
import com.dtflys.forest.annotation.Get;

import java.util.Map;

/**
 * 高德第三方接口
 */
public interface GaoDeHttpClient {


    @Get(url = "https://movie.douban.com/j/search_subjects?type=movie&tag=%E6%9C%80%E6%96%B0&page_limit=50&page_start=0")
    Map getLocation();

}
