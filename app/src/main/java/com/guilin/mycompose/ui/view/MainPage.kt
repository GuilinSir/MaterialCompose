package com.guilin.mycompose.ui.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.guilin.mycompose.R
import com.guilin.mycompose.ui.view.main.BasicPage
import com.guilin.mycompose.ui.view.main.DesignPage
import com.guilin.mycompose.ui.view.main.LayoutPage
import com.guilin.mycompose.ui.view.main.LookOnPage
import kotlinx.coroutines.launch

/**
 * @description:
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/6/29 9:55 AM
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NavController.MainPage (){
    var selectedIndex = remember {
        mutableStateOf(0)
    }
    Column {
        val pagerState = rememberPagerState(selectedIndex.value, 0f)
        HorizontalPager(pageCount = 4, state = pagerState, modifier = Modifier.weight(1f)) { page ->
            when (page) {
                0 -> BasicPage()
                1 -> LayoutPage()
                2 -> DesignPage()
                3 -> LookOnPage()
            }
        }
        BottomNav(selectedIndex, pagerState)
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BottomNav(selectedIndex: MutableState<Int>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    val listItems = listOf(
        stringResource(R.string.first_tab_title),
        stringResource(R.string.second_tab_title),
        stringResource(R.string.third_tab_title),
        stringResource(R.string.fourth_tab_title),
    )


    BottomNavigation(backgroundColor = Color.White) {
        listItems.forEachIndexed { index, s ->
            BottomNavigationItem(
                selected = selectedIndex.value == index,
                icon = {
                    when (index) {
                        0 -> BottomIcon(Icons.Filled.Home, selectedIndex.value, index)
                        1 -> BottomIcon(Icons.Filled.Home, selectedIndex.value, index)
                        2 -> BottomIcon(Icons.Filled.Home, selectedIndex.value, index)
                        3 -> BottomIcon(Icons.Filled.Home, selectedIndex.value, index)
                    }
                },
                label = {
                    Text(
                        s,
                        color = if (selectedIndex.value == index) MaterialTheme.colorScheme.primary else Color.Gray,
                        fontSize = 12.sp,
                    )
                },
                onClick = {
                    selectedIndex.value = index
                    scope.launch {
                        pagerState.scrollToPage(index)
                    }
                },
                selectedContentColor = MaterialTheme.colorScheme.primary,
                unselectedContentColor = Color.Gray,
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