package com.example.newsdemo.ui.theme.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsdemo.ui.theme.components.EmptyStateComponent
import com.example.newsdemo.ui.theme.components.Loader
import com.example.newsdemo.ui.theme.components.NewsRowComponent
import com.example.newsdemo.ui.theme.components.NoNetworkComponent
import com.example.newsdemo.ui.theme.viewmodel.NewsViewModel
import com.example.utilities.CoreUtility
import com.example.utilities.ResourceState

const val TAG = "HomeScreen"

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(newsViewModel: NewsViewModel = hiltViewModel()) {

    if (CoreUtility.isInternetConnected(LocalContext.current)) {
        val newsRes by newsViewModel.news.collectAsState()

        val pagerState = rememberPagerState(initialPage = 0, initialPageOffsetFraction = 0f) {
            50
        }

        VerticalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
            pageSize = PageSize.Fill,
            pageSpacing = 8.dp
        ) { page ->
            when (newsRes) {
                is ResourceState.Loading -> {
                    Loader()
                }

                is ResourceState.Success -> {
                    val response = (newsRes as ResourceState.Success).data
                    if (response.articles.isNotEmpty()) {
                        NewsRowComponent(page, response.articles[page])
                    } else {
                        EmptyStateComponent()
                    }
                }

                is ResourceState.Error -> {
                    val error = (newsRes as ResourceState.Error)
                }
            }
        }
    } else {
        NoNetworkComponent()
    }
}