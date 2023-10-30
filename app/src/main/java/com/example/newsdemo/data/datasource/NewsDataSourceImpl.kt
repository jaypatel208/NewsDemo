package com.example.newsdemo.data.datasource

import com.example.newsdemo.data.api.ApiService
import com.example.newsdemo.data.entity.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(private var apiService: ApiService) : NewsDataSource {
    override suspend fun getNewsHeadline(country: String): Response<NewsResponse> {
        return apiService.getNewsHeadline(country)
    }
}