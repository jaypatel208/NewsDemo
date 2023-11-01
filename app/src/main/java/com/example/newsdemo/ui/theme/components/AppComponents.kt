package com.example.newsdemo.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.newsdemo.R
import com.example.newsdemo.data.entity.Article
import com.example.newsdemo.ui.theme.Purple40

@Composable
fun Loader() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
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
fun NormalTextComponent(textValue: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .wrapContentHeight(), text = textValue, style = TextStyle(
            fontSize = 18.sp, fontWeight = FontWeight.Normal, fontFamily = FontFamily.Monospace, color = Purple40
        )
    )
}

@Composable
fun HeadingTextComponent(textValue: String, centerAligned: Boolean = false) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .wrapContentHeight(),
        text = textValue,
        style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Medium),
        textAlign = if (centerAligned) TextAlign.Center else TextAlign.Start
    )
}

@Composable
fun AuthorDetailsComponent(authorName: String?, sourceName: String?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, bottom = 24.dp)
    ) {
        authorName?.also {
            Text(text = it)
        }

        Spacer(modifier = Modifier.weight(1f))

        sourceName?.also {
            Text(text = it)
        }
    }
}

@Composable
fun EmptyStateComponent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.news_no_data), contentDescription = null
        )

        HeadingTextComponent(textValue = stringResource(R.string.no_news), centerAligned = true)
    }
}

@Composable
fun NoNetworkComponent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.no_network), contentDescription = null
        )

        HeadingTextComponent(textValue = stringResource(R.string.no_internet), centerAligned = true)
    }
}

@Composable
fun NewsRowComponent(page: Int, article: Article) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding()
            .background(Color.White)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            model = article.urlToImage,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.news_placeholder),
            error = painterResource(id = R.drawable.news_error)
        )

        Spacer(modifier = Modifier.size(20.dp))

        HeadingTextComponent(textValue = article.title ?: "")

        Spacer(modifier = Modifier.size(10.dp))

        NormalTextComponent(textValue = article.description ?: "")

        Spacer(modifier = Modifier.size(10.dp))

        Spacer(modifier = Modifier.weight(1f))

        AuthorDetailsComponent(article.author, article.source?.name)
    }
}