package com.guilin.mycompose.ui.view.main

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.guilin.mycompose.R
import com.guilin.mycompose.utils.getStatusBarHeightDp

/**
 * @description:demo
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/6/26 3:44 PM
 */


@SuppressLint("InternalInsetResource", "DiscouragedApi")
@Composable
fun NavController.LookOnPage() {
    Scaffold() {
        Column(
            Modifier
                .verticalScroll(
                    state = rememberScrollState(),
                    // reverseScrolling = true // reverseScrolling设置为true的话,默认自动滚动到底部
                )
                .fillMaxWidth()
                .padding(it)
                .background(MaterialTheme.colorScheme.surface)
                .padding(top = getStatusBarHeightDp())
        ) {
            TopBar()
            SearchBar()
            NamesBar()
            GirlsArea()
            AsyncImage(
                modifier = Modifier.fillMaxWidth().padding(20.dp,10.dp),
                model = "https://www.yangwangauto.com/content/dam/r-site/cn/car/r4-car-s3.jpg",
                contentDescription = "图片"
            )
        }
//        val list = listOf<BottomBarBean>()
//            .plus(BottomBarBean(R.drawable.icon1, "基础组件"))
//            .plus(BottomBarBean(R.drawable.icon2, "布局组件"))
//            .plus(BottomBarBean(R.drawable.icon2, "设计"))
//            .plus(BottomBarBean(R.drawable.icon2, "Demo"))
//        BottomBarView(list)
    }
}

@Composable
fun TopBar() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(20.dp, 10.dp, 20.dp, 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.img_avatar),
            contentDescription = "头像",
            Modifier
                .padding(start = 10.dp)
                .size(64.dp)
                .clip(CircleShape)
        )
        Column(
            Modifier
                .padding(start = 20.dp)
                .weight(1f)
        ) {
            Text(
                "新能源",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,

                )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                "汽车图鉴",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )

        }
        Surface(
            Modifier.clip(CircleShape),
            color = MaterialTheme.colorScheme.primary
        ) {
            Icon(
                painter = painterResource(R.drawable.icon5),
                contentDescription = "通知",
                Modifier
                    .padding(10.dp)
                    .size(22.dp),
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Composable
fun SearchBar() {
    Row(
        Modifier
            .padding(20.dp, 10.dp)
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant),
        verticalAlignment = Alignment.CenterVertically
    ) {
        var searchText by remember {
            mutableStateOf("")
        }
        BasicTextField(
            searchText, onValueChange = { searchText = it },
            Modifier
                .padding(15.dp)
                .weight(1f),
            textStyle = TextStyle(fontSize = 14.sp)
        ) {
            if (searchText.isEmpty()) {
                Text(
                    "搜搜看？",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = 16.sp
                )
            }
            it()
        }

        Box(
            Modifier
                .padding(10.dp)
                .fillMaxHeight()
                .aspectRatio(1f)
                .clip(CircleShape)
                .background(
                    MaterialTheme.colorScheme.primary
                )
        ) {
            Icon(
                //painter = painterResource(id = R.drawable.icon_search),
                imageVector = Icons.Filled.Search,
                contentDescription = "搜索",
                Modifier
                    .padding(2.dp)
                    //.size(24.dp)
                    .align(Alignment.Center),
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Composable
fun NamesBar() {
    var names =
        listOf("比亚迪", "特斯拉", "极氪", "蔚来", "小鹏", "AITO", "领跑", "理想", "问界", "特斯拉")
    var selected by rememberSaveable {
        mutableStateOf(0)
    }
    LazyRow(Modifier.padding(0.dp, 8.dp), contentPadding = PaddingValues(12.dp, 0.dp)) {
        itemsIndexed(names) { index, item ->
            Column(
                Modifier
                    .padding(8.dp, 4.dp)
                    .width(IntrinsicSize.Max)
            ) {
                ClickableText(
                    text = AnnotatedString(item),
                    onClick = {
                        selected = index
                    },
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = if (index == selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground,
                        fontWeight = if (index == selected) FontWeight.Bold else FontWeight.Normal,
                        textAlign = TextAlign.Center,
                    )
                )
                if (index == selected) {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 2.dp)
                            .height(2.dp)
                            //.padding(0.dp,2.dp)
                            .clip(RoundedCornerShape(1.dp))
                            .background(MaterialTheme.colorScheme.primary)
                    )
                }
            }
        }
    }
}

@Composable
fun GirlsArea() {
    var photos = mutableListOf<Int>()
    photos.add(R.drawable.pic1)
    photos.add(R.drawable.pic1)
    photos.add(R.drawable.pic1)
    photos.add(R.drawable.pic1)
    Row(

        Modifier
            .padding(24.dp, 12.dp, 24.dp)
            .fillMaxWidth()
    ) {
        Text(
            "汽车展示",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "查看全部", fontSize = 14.sp, color = MaterialTheme.colorScheme.outline)
    }
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        contentPadding = PaddingValues(24.dp, 0.dp)
    ) {
        itemsIndexed(photos) { index, item ->
            Column(
                Modifier
                    .padding(0.dp, 12.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .padding(0.dp, 10.dp)
            ) {
                Image(
                    painter = painterResource(item),
                    contentDescription = "照片",
                    Modifier
                        //.height(280.dp)
                        .padding(10.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
                Row(Modifier.padding(10.dp, 10.dp, 0.dp, 0.dp)) {
                    Text(
                        "型号:",
                        Modifier
                            .fillMaxWidth(),
                        //.align(Alignment.CenterHorizontally),
                        //fontWeight = FontWeight.ExtraBold,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                    )
                    Text(
                        "U9",
                        Modifier
                            .padding(10.dp, 0.dp, 0.dp, 0.dp)
                            .fillMaxWidth(),
                        //.align(Alignment.CenterHorizontally),
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                    )
                }
                Row(Modifier.padding(10.dp, 5.dp, 0.dp, 0.dp)) {
                    Text(
                        "品牌:",
                        Modifier
                            .fillMaxWidth(),
                        //.align(Alignment.CenterHorizontally),
                        //fontWeight = FontWeight.ExtraBold,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                    )
                    Text(
                        "仰望",
                        Modifier
                            .padding(10.dp, 0.dp, 0.dp, 0.dp)
                            .fillMaxWidth(),
                        //.align(Alignment.CenterHorizontally),
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                    )
                }

            }
        }
    }
}



