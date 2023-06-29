package com.guilin.mycompose.ui.view.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.guilin.mycompose.ui.view.wight.TopBarView

/**
 * @description:基础组件
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/6/28 8:26 AM
 */
val list = listOf<String>(
    "Alertdialog",
    "Button",
    "Card",
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
        "Alertdialog" -> navController.navigate("alertdialog_page/" + "123")
        "Button" -> navController.navigate("button_page")
    }

}


@Composable
fun NavController.BasicPage() {
    //verticalArrangement = Arrangement.Center,
    //horizontalAlignment = Alignment.CenterHorizontally

    Column(Modifier.fillMaxSize()) {
        TopBarView(false, "基础组件", this@BasicPage)
        BasicListView(list = list, Modifier.weight(1f), this@BasicPage)
    }

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
            startIndent = 0.dp,
            modifier = Modifier
                .padding(24.dp, 0.dp),
        )
    }
}

