package com.berliana.news_api.config;

import com.berliana.news_api.BuildConfig;

/**
 * Created by berlianalina on 5/14/18.
 */

public class Constant {
    public final static String API_HOST = "https://newsapi.org/";
    public final static String API_KEY = BuildConfig.API_KEY;
    public final static String[] CATEGORY = {"business", "entertainment", "general",
            "health", "science", "sports", "technology"};
}
