package com.example.newsdemo.ui.theme.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.newsdemo.R
import com.example.newsdemo.data.entity.Article

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
                .padding(10.dp), color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun NormalTextComponent(textValue: String, centerAligned: Boolean = false) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .wrapContentHeight(), text = textValue, style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily(Font(R.font.roboto_regular, FontWeight.Medium)),
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = if (centerAligned) TextAlign.Center else TextAlign.Start
        )
    )
}

@Composable
fun HeadingTextComponent(textValue: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .wrapContentHeight(),
        text = textValue,
        style = TextStyle(
            fontSize = 28.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily(Font(R.font.roboto_regular, FontWeight.Normal)),
            color = MaterialTheme.colorScheme.primary
        )
    )
}

@Composable
fun AuthorTextComponent(textValue: String) {
    Text(
        modifier = Modifier
            .wrapContentSize(), text = textValue, style = TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily(Font(R.font.roboto_condensed, FontWeight.Medium)),
            color = MaterialTheme.colorScheme.inverseSurface, letterSpacing = 0.5.sp
        )
    )
}

@Composable
fun SourceTextComponent(textValue: String) {
    Text(
        modifier = Modifier
            .wrapContentSize(), text = textValue, style = TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily(Font(R.font.roboto_condensed, FontWeight.Medium)),
            color = MaterialTheme.colorScheme.inverseSurface, letterSpacing = 0.5.sp
        )
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
            AuthorTextComponent(textValue = it)
        }

        Spacer(modifier = Modifier.weight(1f))

        sourceName?.also {
            SourceTextComponent(textValue = it)
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

        NormalTextComponent(textValue = stringResource(R.string.no_news), centerAligned = true)
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

        NormalTextComponent(textValue = stringResource(R.string.no_internet), centerAligned = true)
    }
}

@Composable
fun NewsRowComponent(page: Int, article: Article) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding()
            .background(MaterialTheme.colorScheme.surface)
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

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NewsSearchBar() {
    var text by remember {
        mutableStateOf("")
    }
    var active by remember {
        mutableStateOf(false)
    }
    val items = remember {
        mutableStateListOf("Android", "Apple", "War", "Twitter", "Finance")
    }

    val modifier = if (active) Modifier
        .fillMaxSize() else Modifier
        .padding(12.dp)
    Box(
        modifier = modifier
    ) {
        SearchBar(
            modifier = Modifier.fillMaxWidth(), query = text,
            onQueryChange = { text = it },
            onSearch = {
                items.add(text)
                active = false
            },
            active = active,
            onActiveChange = { active = it },
            leadingIcon = {
                Icon(imageVector = Icons.Outlined.Search, contentDescription = null)
            }, trailingIcon = {
                if (active) {
                    Icon(
                        modifier = Modifier.clickable {
                            if (text.isNotEmpty()) {
                                text = ""
                            } else {
                                active = false
                            }
                        },
                        imageVector = Icons.Outlined.Close,
                        contentDescription = "Close icon"
                    )
                }
            },
            placeholder = { Text(text = "Search") }
        ) {
            items.asReversed().forEach {
                Row(modifier = Modifier.padding(all = 14.dp)) {
                    Icon(
                        modifier = Modifier.padding(end = 10.dp),
                        imageVector = Icons.Outlined.History,
                        contentDescription = "History Icon"
                    )
                    Text(text = it)
                }
            }
        }
    }
}