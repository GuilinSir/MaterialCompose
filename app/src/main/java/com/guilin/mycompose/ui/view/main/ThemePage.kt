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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.guilin.common.constant.SpKey
import com.guilin.mycompose.R
import com.guilin.mycompose.bean.BottomBarBean
import com.guilin.mycompose.bean.ThemeBean
import com.guilin.mycompose.enum.ThemeEnum
import com.guilin.mycompose.ui.theme.state
import com.guilin.mycompose.ui.theme.themeTypeState
import com.guilin.mycompose.ui.wight.TopBarView
import com.guilin.mycompose.utils.MMKVDelegate
import com.guilin.mycompose.utils.MMKVUtils

/**
 * @description:主题切换
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/6/28 3:26 PM
 */
val themeList = listOf<ThemeBean>()
    .plus(ThemeBean(ThemeEnum.PURPLE_THEME.state, ThemeEnum.PURPLE_THEME.colorName))
    .plus(ThemeBean(ThemeEnum.GREEN_THEME.state, ThemeEnum.GREEN_THEME.colorName))
    .plus(ThemeBean(ThemeEnum.RED_THEME.state, ThemeEnum.RED_THEME.colorName))
    .plus(ThemeBean(ThemeEnum.ORANGE_THEME.state, ThemeEnum.ORANGE_THEME.colorName))


@Composable
fun NavController.ThemePage() {
    Scaffold(topBar = {
        TopBarView(false, stringResource(R.string.third_tab_title), this@ThemePage, true)
    }, content = {
        Column(Modifier.padding(it)) {
            ThemeListView(themeList, Modifier.weight(1f))
        }
    })
}

@Composable
fun ThemeListView(list: List<ThemeBean>, modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        itemsIndexed(list) { index, item ->
            ThemeRow(item)
        }
    }
}

@Composable
fun ThemeRow(item: ThemeBean) {
    Column(
        Modifier
            .fillMaxWidth()
            .height(60.dp)
            .clickable {
                state = item.state
                //MMKVUtils.encode(SpKey.CHANGED_THEME, item.state)
                themeTypeState.value.value = item.state
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