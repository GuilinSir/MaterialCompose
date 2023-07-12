package com.guilin.mycompose.ui.view

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.guilin.mycompose.R
import com.guilin.mycompose.bean.BottomBarBean
import com.guilin.mycompose.ui.view.main.BasicPage
import com.guilin.mycompose.ui.view.main.DesignPage
import com.guilin.mycompose.ui.view.main.LayoutPage
import com.guilin.mycompose.ui.view.main.LookOnPage
import com.guilin.mycompose.ui.view.main.ThemePage
import com.guilin.mycompose.ui.wight.BottomBarView
import kotlinx.coroutines.launch

/**
 * @description:主页
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/6/29 9:55 AM
 */
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NavController.MainPage() {

    val pagerState = rememberPagerState(pageCount = {
        5
    })
    Column {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            when (page) {
                0 -> BasicPage()
                1 -> LayoutPage()
                2 -> DesignPage()
                3 -> LookOnPage()
                4 -> ThemePage()
            }
        }
        //BottomNav(pagerState)
        val list = listOf<BottomBarBean>()
            .asSequence()
            .plus(BottomBarBean(R.drawable.icon1, stringResource(R.string.first_tab_title)))
            .plus(BottomBarBean(R.drawable.icon2, stringResource(R.string.second_tab_title)))
            .plus(BottomBarBean(R.drawable.icon2, stringResource(R.string.third_tab_title)))
            .plus(BottomBarBean(R.drawable.icon2, stringResource(R.string.fourth_tab_title)))
            .plus(BottomBarBean(R.drawable.icon2, stringResource(R.string.fifth_tab_title)))
            .toList()
        BottomBarView(list, pagerState)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BottomNav(pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    val listItems = listOf(
        stringResource(R.string.first_tab_title),
        stringResource(R.string.second_tab_title),
        stringResource(R.string.third_tab_title),
        stringResource(R.string.fourth_tab_title),
        stringResource(R.string.fourth_tab_title),
    )


    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primary,
        modifier = Modifier.height(60.dp)
    ) {
        listItems.forEachIndexed { index, s ->
            NavigationBarItem(
                icon = {
                    when (index) {
                        0 -> BottomIcon(Icons.Filled.Home, pagerState.currentPage, index)
                        1 -> BottomIcon(Icons.Filled.Home, pagerState.currentPage, index)
                        2 -> BottomIcon(Icons.Filled.Home, pagerState.currentPage, index)
                        3 -> BottomIcon(Icons.Filled.Home, pagerState.currentPage, index)
                    }
                },
                label = {
                    Text(
                        s,
                        color = if (index == pagerState.currentPage) MaterialTheme.colorScheme.onPrimary else Color.Gray,
                        fontSize = 14.sp,
                        //style = MaterialTheme.typography.bodySmall
                    )
                },
                onClick = {
                    scope.launch {
                        pagerState.scrollToPage(index)

                    }
                },
                selected = pagerState.currentPage == index,
            )

        }
    }
}

@Composable
private fun BottomIcon(imageVector: ImageVector, selectedIndex: Int, index: Int) {
    Icon(
        imageVector,
        null,
        tint = if (selectedIndex == index) MaterialTheme.colorScheme.primary else Color.Gray
    )
}