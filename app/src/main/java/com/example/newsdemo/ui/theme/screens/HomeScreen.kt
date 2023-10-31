package com.example.newsdemo.ui.theme.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsdemo.ui.theme.components.Loader
import com.example.newsdemo.ui.theme.components.NewsRowComponent
import com.example.newsdemo.ui.theme.viewmodel.NewsViewModel
import com.example.utilities.ResourceState

const val TAG = "HomeScreen"

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(newsViewModel: NewsViewModel = hiltViewModel()) {
    val newsRes by newsViewModel.news.collectAsState()

    val pagerState = rememberPagerState(initialPage = 0, initialPageOffsetFraction = 0f)

    VerticalPager(
        pageCount = 100,
        state = pagerState,
        modifier = Modifier.fillMaxSize(),
        pageSize = PageSize.Fill,
        pageSpacing = 8.dp
    ) { page ->
        when (newsRes) {
            is ResourceState.Loading -> {
                Log.d(TAG, "HomeScreen: Inside Loading")
                Loader()
            }

            is ResourceState.Success -> {
                val response = (newsRes as ResourceState.Success).data
                Log.d(TAG, "HomeScreen: Inside Success ${response.status} = ${response.totalResults}")
                if (response.articles.isNotEmpty()){
                    NewsRowComponent(page, response.articles[page])
                }
            }

            is ResourceState.Error -> {
                val error = (newsRes as ResourceState.Error)
                Log.d(TAG, "HomeScreen: Inside Error $error")
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}