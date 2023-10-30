package com.example.newsdemo.data.datasource

import com.example.newsdemo.data.entity.NewsResponse
import retrofit2.Response

interface NewsDataSource {
    suspend fun getNewsHeadline(country: String): Response<NewsResponse>
}