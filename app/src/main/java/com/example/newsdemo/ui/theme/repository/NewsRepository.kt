package com.example.newsdemo.ui.theme.repository

import com.example.newsdemo.data.datasource.NewsDataSource
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsDataSource: NewsDataSource) {

}