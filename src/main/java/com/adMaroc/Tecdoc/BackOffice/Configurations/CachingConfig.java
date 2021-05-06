package com.adMaroc.Tecdoc.BackOffice.Configurations;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@EnableCaching
public class CachingConfig {

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(
                new ConcurrentMapCache("searchStructure"),
                new ConcurrentMapCache("genericArticles"),
                new ConcurrentMapCache("savedManufacturers"),
                new ConcurrentMapCache("keyTables"),
                new ConcurrentMapCache("manufacturers"),
                new ConcurrentMapCache("images"),
                new ConcurrentMapCache("articles"),
                new ConcurrentMapCache("article"),
                new ConcurrentMapCache("genericArticles"),
                new ConcurrentMapCache("genericArticle"),
                new ConcurrentMapCache("vehicleModelSeries"),
                new ConcurrentMapCache("vehicleTypes"),
                new ConcurrentMapCache("criteria"),
                new ConcurrentMapCache("cvTypes"),
                new ConcurrentMapCache("manyfacturer"),
                new ConcurrentMapCache("countryAndlanguageDescriptions"),
                new ConcurrentMapCache("languageDescriptions"),
                new ConcurrentMapCache("textModules"))
        );
        return cacheManager;
    }
}

