package com.guilin.mycompose.ui.view.wight

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.guilin.mycompose.bean.BottomBarBean
import kotlinx.coroutines.launch

/**
 * @description:
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/6/30 2:12 PM
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BottomBarView(list: List<BottomBarBean>, pagerState: PagerState) {

    Row(
        Modifier
            .height(60.dp),

        //verticalAlignment = Alignment.CenterVertically
    ) {
        list.forEachIndexed { index, s ->
            NavItem(index, s, pagerState)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RowScope.NavItem(index: Int, buttomBarBean: BottomBarBean, pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    Button(
        onClick = {
            scope.launch {
                pagerState.scrollToPage(index)
            }
        },
        Modifier
            .weight(1f)
            .fillMaxHeight(),
        shape = RectangleShape,
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (index == pagerState.currentPage) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.background
        )
    ) {
        Column(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painterResource(buttomBarBean.iconRes),
                "图标",
                Modifier
                    .size(20.dp),
                tint = if (index == pagerState.currentPage) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onBackground
            )
            Text(
                buttomBarBean.text,
                Modifier
                    .padding(0.dp, 2.dp),
                fontSize = 12.sp,
                color = if (index == pagerState.currentPage) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onBackground,
            )
        }

    }


}