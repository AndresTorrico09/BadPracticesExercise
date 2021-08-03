package com.distillery.exercise.data

import com.distillery.exercise.data.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {
    @GET("/v2/everything")
    suspend fun searchNews(@Query("q") query: String): Response<NewsResponse>

    companion object {
        const val BASE_URL = "https://newsapi.org"
    }
}