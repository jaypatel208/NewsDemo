package com.example.newsdemo.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsdemo.data.entity.Article
import com.example.newsdemo.data.entity.NewsResponse
import com.example.newsdemo.ui.theme.Purple40

@Composable
fun Loader() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(60.dp)
                .padding(10.dp), color = Purple40
        )
    }
}

@Composable
fun NewsList(response: NewsResponse) {
    LazyColumn {
        items(response.articles) { article ->
            NormalTextComponent(textValue = article.title ?: "Not available")
        }
    }
}

@Composable
fun NormalTextComponent(textValue: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .wrapContentHeight(), text = textValue, style =
        TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Normal)
    )
}

@Composable
fun NewsRowComponent(page: Int, article: Article) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding()
        .background(Color.White)) {

    }
}

@Preview
@Composable
fun NewsRowComponentPreview() {
    val article = Article(
        author = "John Wick",
        title = "2014",
        url = null,
        content = null,
        description = null,
        publishedAt = null,
        source = null,
        urlToImage = null
    )
    NewsRowComponent(page = 0, article =article)
}