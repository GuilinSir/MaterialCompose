package com.guilin.mycompose.ui.view.components.icon_button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.guilin.mycompose.ui.wight.TopBarView

/**
 * @description:填充色调图标按钮是中等强调图标按钮，
 * 是默认按钮FilledIconButton和之间的替代中间地带OutlinedIconButton。
 * 它们可以用在优先级较低的图标按钮需要比大纲稍微强调的环境中。
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/7/14 9:42 AM
 *
 */
@Composable
fun NavController.FilledTonalIconButtonPage() {
    Scaffold(
        topBar = {
            TopBarView(
                true,
                "FilledTonalIconButton",
                this@FilledTonalIconButtonPage,
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
                FilledTonalIconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
                }
            }
        }
    )

}


