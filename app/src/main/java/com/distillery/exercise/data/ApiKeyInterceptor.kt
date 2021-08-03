package com.distillery.exercise.data

import com.distillery.exercise.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {

    companion object {
        private const val API_KEY = "apiKey"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request();
        val originalHttpUrl = originalRequest.url()

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter(API_KEY, BuildConfig.NEWS_API_KEY)
            .build();

        val request = originalRequest.newBuilder()
            .url(url)
            .build()

        return chain.proceed(request);
    }
}