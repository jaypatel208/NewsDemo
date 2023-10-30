package com.example.newsdemo.data.api

import com.example.newsdemo.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    //GET https://newsapi.org/v2/top-headlines?country=us&apiKey=c62bbeb4a7224d2a928fdf2b515c7125
    @GET("v2/top-headlines")
    suspend fun getNewsHeadline(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = "c62bbeb4a7224d2a928fdf2b515c7125"
    ): Response<NewsResponse>
}