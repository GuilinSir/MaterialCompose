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
import com.guilin.mycompose.ui.wight.TopBarView

/**
 * @description:布局组件
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/6/28 8:26 AM
 */
val layoutList = listOf<String>(
    "BottomAppBar",
    "BottomSheetScaffold",
    "CenterAlignedTopAppBar"
)

fun layoutClickEvent(item: String, navController: NavController) {
    when (item) {
        "BottomAppBar" -> NavHost().Navigate(navController, "bottom_app_bar_page")
        "BottomSheetScaffold" -> NavHost().Navigate(navController, "bottom_sheet_scaffold_page")
        "CenterAlignedTopAppBar" ->NavHost().Navigate(navController, "center_aligned_top_app_bar_page")
    }
}


@Composable
fun NavController.LayoutPage() {
    //verticalArrangement = Arrangement.Center,
    //horizontalAlignment = Alignment.CenterHorizontally
    Scaffold(topBar = {
        TopBarView(false, stringResource(R.string.third_tab_title), this@LayoutPage, true)
    }, content = {
        Column(Modifier.padding(it)) {
            LayoutListView(list = layoutList, Modifier.weight(1f), this@LayoutPage)
        }
    })
}


@Composable
fun LayoutListView(list: List<String>, modifier: Modifier, navController: NavController) {
    LazyColumn(modifier = modifier) {
        itemsIndexed(list) { index, item ->
            LayoutRow(item, navController)
        }
    }
}

@Composable
fun LayoutRow(item: String, navController: NavController) {
    Column(
        Modifier
            .fillMaxWidth()
            .height(60.dp)
            .clickable {
                layoutClickEvent(item, navController)
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

