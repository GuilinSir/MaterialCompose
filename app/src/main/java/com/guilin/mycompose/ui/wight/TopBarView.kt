package com.guilin.mycompose.ui.wight

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.guilin.mycompose.utils.getStatusBarHeight
import com.guilin.mycompose.utils.getStatusBarHeightDp

/**
 * @description:
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/6/29 11:03 AM
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarView(
    isBack: Boolean,
    title: String,
    navController: NavController,
    isImmersive: Boolean = false
) {
    val topAppBarHeight = 50.dp

    if (isImmersive) {
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setSystemBarsColor(
                color = Color.Transparent,
                //darkIcons = darkIcons
            )
        }
    }
    Column(
        Modifier
            .height(topAppBarHeight + getStatusBarHeightDp())
            .background(MaterialTheme.colorScheme.primary)
    ) {
        if(isImmersive) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(getStatusBarHeightDp())
            )
        }
        //自定义的appbar
        Box(
            Modifier
                .height(topAppBarHeight)
        ) {
            Text(
                title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(topAppBarHeight)
                    .wrapContentSize(Alignment.Center)
            )
            if (isBack) {
                //返回按钮
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(Icons.Filled.ArrowBack, null, tint = MaterialTheme.colorScheme.onPrimary)
                }
            }
        }
    }
}


