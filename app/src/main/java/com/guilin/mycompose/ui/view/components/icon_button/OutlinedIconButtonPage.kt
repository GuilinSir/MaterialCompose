package com.guilin.mycompose.ui.view.components.icon_button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.guilin.mycompose.ui.wight.TopBarView

/**
 * @description:当组件需要与背景有更多视觉分离时，请使用此“contained”图标按钮。
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :  2023/7/14 9:42 AM
 *
 */
@Composable
fun NavController.OutlinedIconButtonPage() {
    Scaffold(
        topBar = {
            TopBarView(
                true,
                "OutlinedIconButton",
                this@OutlinedIconButtonPage,
                true
            )
        },
        content = {
            Column(
                Modifier
                    .padding(it)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                OutlinedIconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
                }
            }
        }
    )

}


