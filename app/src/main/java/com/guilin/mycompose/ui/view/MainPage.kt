package com.guilin.mycompose.ui.view

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.guilin.mycompose.R
import com.guilin.mycompose.bean.BottomBarBean
import com.guilin.mycompose.ui.view.main.ComponentsPage
import com.guilin.mycompose.ui.view.main.DesignPage
import com.guilin.mycompose.ui.view.main.LookOnPage
import com.guilin.mycompose.ui.view.main.ThemePage
import com.guilin.mycompose.ui.wight.BottomBarView

/**
 * @description:主页
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/6/29 9:55 AM
 */
@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NavController.MainPage() {
    val pagerState = rememberPagerState(pageCount = { 4 })
    Column {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            when (page) {
                0 -> ComponentsPage()
                1 -> DesignPage()
                2 -> LookOnPage()
                3 -> ThemePage()
            }
        }
        val list = listOf<BottomBarBean>()
            .asSequence()
            .plus(BottomBarBean(R.drawable.icon1, stringResource(R.string.zero_tab_title)))
            .plus(BottomBarBean(R.drawable.icon2, stringResource(R.string.third_tab_title)))
            .plus(BottomBarBean(R.drawable.icon2, stringResource(R.string.fourth_tab_title)))
            .plus(BottomBarBean(R.drawable.icon2, stringResource(R.string.fifth_tab_title)))
            .toList()
        BottomBarView(list, pagerState)
    }
}