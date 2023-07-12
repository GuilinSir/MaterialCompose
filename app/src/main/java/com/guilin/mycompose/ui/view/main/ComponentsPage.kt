package com.guilin.mycompose.ui.view.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.guilin.mycompose.R
import com.guilin.mycompose.bean.ComponentsBean
import com.guilin.mycompose.bean.ComponentsChild
import com.guilin.mycompose.constant.NavHost
import com.guilin.mycompose.constant.NavRoute
import com.guilin.mycompose.ui.wight.TopBarView
import com.guilin.mycompose.utils.JsonReadUtils

/**
 * @description:
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/7/12 3:35 PM
 */
@Composable
fun NavController.ComponentsPage() {
    val jsonContent = JsonReadUtils.getInstance().get(this@ComponentsPage.context, R.raw.components)
    val type = object : TypeToken<List<ComponentsBean>>() {}.type
    val list: List<ComponentsBean> = Gson().fromJson(jsonContent, type)
    Scaffold(topBar = {
        TopBarView(false, "Components", this@ComponentsPage, true)
    }, content = {
        ComponentsListView(list = list, Modifier.padding(it), this@ComponentsPage)
    })
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ComponentsListView(
    list: List<ComponentsBean>,
    modifier: Modifier,
    navController: NavController
) {
    LazyColumn(modifier = modifier) {
        list.forEachIndexed { index, data ->
            stickyHeader() {
                Row(
                    modifier = Modifier
                        .background(color = MaterialTheme.colorScheme.secondary)
                        .height(30.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = data.name, modifier = Modifier
                            .weight(1f)
                            .padding(start = 10.dp),
                        color = MaterialTheme.colorScheme.onSecondary
                    )
                    Icon(
                        imageVector = Icons.Filled.ExpandMore,
                        contentDescription = "查看",
                        tint = MaterialTheme.colorScheme.onSecondary
                    )
                }

            }
            itemsIndexed(data.children) { index, item ->
                ComponentsRow(item, navController)
            }
        }
    }
}

@Composable
fun ComponentsRow(item: ComponentsChild, navController: NavController) {
    Column(
        Modifier
            .fillMaxWidth()
            .height(60.dp)
            .clickable {
                componentsClickEvent(item.name, navController)
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
            Text(text = item.name, modifier = Modifier.weight(1f))
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

fun componentsClickEvent(item: String, navController: NavController) {
    when (item) {
        "AlertDialog" -> NavHost().Navigate(
            navController,
            NavRoute.ALERT_DIALOG_PAGE + "/" + "123"
        )

        "AssistChip" -> NavHost().Navigate(navController, NavRoute.ASSIST_CHIP_PAGE)
        "Badge" -> NavHost().Navigate(navController, NavRoute.BADGE_PAGE)
        "Button" -> NavHost().Navigate(navController, NavRoute.BUTTON_PAGE)
        "Card" -> NavHost().Navigate(navController, NavRoute.CARD_PAGE)
        "Checkbox" -> NavHost().Navigate(navController, NavRoute.CHECKBOX_PAGE)
        "FloatingActionButton" -> NavHost().Navigate(
            navController,
            NavRoute.FLOATING_ACTION_BUTTON_PAGE
        )

        "Icon" -> NavHost().Navigate(navController, NavRoute.ICON_PAGE)
        "IconButton" -> NavHost().Navigate(navController, NavRoute.ICON_BUTTON_PAGE)
        "Image" -> NavHost().Navigate(navController, NavRoute.IMAGE_PAGE)
        "Slider" -> NavHost().Navigate(navController, NavRoute.SLIDER_PAGE)
        "Text" -> NavHost().Navigate(navController, NavRoute.TEXT_PAGE)
        "TextField" -> NavHost().Navigate(navController, NavRoute.TEXT_FIELD_PAGE)
        "BottomAppBar" -> NavHost().Navigate(
            navController,
            NavRoute.BOTTOM_APP_BAR_PAGE
        )

        "BottomSheetScaffold" -> NavHost().Navigate(
            navController,
            NavRoute.BOTTOM_SHEET_SCAFFOLD_PAGE
        )

        "CenterAlignedTopAppBar" -> NavHost().Navigate(
            navController,
            NavRoute.CENTER_ALIGNED_TOP_APP_BAR_PAGE
        )

        "CircularProgressIndicator" -> NavHost().Navigate(
            navController,
            NavRoute.CIRCULAR_PROGRESS_INDICATOR_PAGE
        )

        "DatePicker" -> NavHost().Navigate(
            navController,
            NavRoute.DATE_PACKER_PAGE
        )

        "DismissibleNavigationDrawer" -> NavHost().Navigate(
            navController,
            NavRoute.DISMISSIBLE_NAVIGATION_DRAWER_PAGE
        )
    }
}