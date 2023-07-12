package com.guilin.mycompose.ui.view.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.guilin.mycompose.R
import com.guilin.mycompose.constant.NavHost
import com.guilin.mycompose.constant.NavRoute
import com.guilin.mycompose.ui.wight.TopBarView

/**
 * @description:基础组件
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/6/28 8:26 AM
 */
val list = listOf<String>(
    "AlertDialog",
    "AssistChip",
    "Badge",
    "Button",
    "Card",
    "Checkbox",
    "FloatingActionButton",
    "Icon",
    "IconButton",
    "Image",
    "Slider",
    "Text",
    "TextField"
)

fun clickEvent(item: String, navController: NavController) {
    when (item) {
        "AlertDialog" -> NavHost().Navigate(navController, NavRoute.ALERT_DIALOG_PAGE + "/" + "123")
        "AssistChip" -> NavHost().Navigate(navController, NavRoute.ASSIST_CHIP_PAGE)
        "Badge" -> NavHost().Navigate(navController, NavRoute.BADGE_PAGE)
        "Button" -> NavHost().Navigate(navController, NavRoute.BUTTON_PAGE)
        "Card" -> NavHost().Navigate(navController, NavRoute.CARD_PAGE)
        "Checkbox" -> NavHost().Navigate(navController, NavRoute.CHECKBOX_PAGE)
        "FloatingActionButton" -> NavHost().Navigate(navController, NavRoute.FLOATING_ACTION_BUTTON_PAGE)
        "Icon" -> NavHost().Navigate(navController, NavRoute.ICON_PAGE)
        "IconButton" -> NavHost().Navigate(navController, NavRoute.ICON_BUTTON_PAGE)
        "Image" -> NavHost().Navigate(navController, NavRoute.IMAGE_PAGE)
        "Slider" -> NavHost().Navigate(navController, NavRoute.SLIDER_PAGE)
        "Text" -> NavHost().Navigate(navController, NavRoute.TEXT_PAGE)
        "TextField" -> NavHost().Navigate(navController, NavRoute.TEXT_FIELD_PAGE)
    }
}


@Composable
fun NavController.BasicPage() {
    //verticalArrangement = Arrangement.Center,
    //horizontalAlignment = Alignment.CenterHorizontally
//    Surface(Modifier.background(MaterialTheme.colorScheme.surface)) {
//        Column(Modifier.fillMaxSize()) {
//            TopBarView(false, stringResource(R.string.first_tab_title), this@BasicPage, true)
//            BasicListView(list = list, Modifier.weight(1f), this@BasicPage)
//        }
//    }
    Scaffold(topBar = {
        TopBarView(false, stringResource(R.string.first_tab_title), this@BasicPage, true)
    }, content = { paddingValues ->
        BasicListView(list = list, Modifier.padding(paddingValues), this@BasicPage)
    })
}


@Composable
fun BasicListView(list: List<String>, modifier: Modifier, navController: NavController) {
    LazyColumn(modifier = modifier) {
        itemsIndexed(list) { index, item ->
            BasicRow(item, navController)
        }
    }
}

@Composable
fun BasicRow(item: String, navController: NavController) {
    Column(
        Modifier
            .fillMaxWidth()
            .height(60.dp)
            .clickable {
                clickEvent(item, navController)
            },
        //Modifier.align(alignment = Alignment.CenterHorizontally) 垂直布局Column 进行水平居中
    ) {
        Row(
            Modifier
                .weight(1f)
                .padding(24.dp, 0.dp),
            //horizontalArrangement = Arrangement.Center,//设置水平居中对齐
            verticalAlignment = Alignment.CenterVertically//设置垂直居中对齐
        ) {
            Text(text = item, modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Filled.NavigateNext,
                contentDescription = "查看",
            )
        }
        Divider(
            //color = Color.Red,
            thickness = 0.5.dp,
            modifier = Modifier
                .padding(24.dp, 0.dp),
        )
    }
}

