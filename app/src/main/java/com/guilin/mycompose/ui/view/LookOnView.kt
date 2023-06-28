package com.guilin.mycompose.ui.view

import android.widget.AdapterView.OnItemClickListener
import androidx.annotation.DrawableRes
import androidx.compose.animation.Animatable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.guilin.mycompose.R

/**
 * @description:
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/6/26 3:44 PM
 */


@Composable
fun LookOnView() {
    Column {
        Column(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color(0xfff4f4f4))
        ) {
            TopBar()
            SearchBar()
            NamesBar()
            GirlsArea()
        }
        //NavBar()
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
                "Arms‘",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xff000000)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                "Girls",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xff000000)
            )

        }
        Surface(
            Modifier.clip(CircleShape),
            color = Color(0xfffef7f0)
        ) {
            Image(
                painter = painterResource(R.drawable.icon5),
                contentDescription = "通知",
                Modifier
                    .padding(10.dp)
                    .size(22.dp)
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
            .background(Color.White),
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
                Text("搜搜看？", color = Color(0xffb4b4b4), fontSize = 16.sp)
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
                    Color(0xfffa9e51)
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
                tint = Color.White
            )
        }
    }
}

@Composable
fun NamesBar() {
    var names =
        listOf("香玲", "海娇", "艺萱", "梦阁", "钰晗", "艳霞", "小然", "思凝")
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
                        color = if (index == selected) Color(0xfffa9e51) else Color(0xff707070),
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
                            .background(Color(0xfffa9e51))
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
        Text("TA 照片", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "查看全部", fontSize = 14.sp, color = Color(0xffb4b4b4))
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
                    .background(Color(0xffffffff))
            ) {
                Image(
                    painter = painterResource(item),
                    contentDescription = "照片",
                    Modifier
                        //.height(280.dp)
                        .padding(10.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
                Text(
                    "吃面YYDS",

                    Modifier
                        .padding(10.dp, 0.dp, 0.dp, 10.dp)
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 14.sp,
                    color = Color.Black,
                )
            }
        }
    }
}

@Composable
fun NavBar() {
    Row(
        Modifier
            .height(60.dp)
            .background(Color(0xffffffff)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        NavItem(R.drawable.icon1, Color(0xfffa9e51))
        NavItem(R.drawable.icon2, Color(0xffb4b4b4))
        NavItem(R.drawable.icon3, Color(0xffb4b4b4))
        NavItem(R.drawable.icon4, Color(0xffb4b4b4))
    }
}

@Composable
private fun RowScope.NavItem(@DrawableRes iconRes: Int, tint: Color) {
    Button(
        onClick = {},
        Modifier
            .weight(1f)
            .fillMaxHeight(),
        shape = RectangleShape,
        colors = ButtonDefaults.outlinedButtonColors()

    ) {
        Icon(
            painterResource(iconRes),
            "图标",
            Modifier
                .size(24.dp)
                .weight(1f),
            tint = tint
        )
    }


}