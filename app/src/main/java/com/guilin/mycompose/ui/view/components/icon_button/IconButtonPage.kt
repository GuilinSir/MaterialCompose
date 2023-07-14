package com.guilin.mycompose.ui.view.components.icon_button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.guilin.mycompose.ui.wight.TopBarView

/**
 * @description:
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/7/14 9:42 AM
 *
 * @Composable
 * fun IconButton(
 *     onClick: () -> Unit,
 *     modifier: Modifier = Modifier,
 *     enabled: Boolean = true,控制该图标按钮的启用状态。当 时false，该组件将不会响应用户输入，并且它将显示为视觉禁用且对辅助功能服务禁用
 *     colors: IconButtonColors = IconButtonDefaults.iconButtonColors(),
 *     interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
 *     content: @Composable () -> Unit
 * ): Unit
 */
@Composable
fun NavController.IconButtonPage() {
    Scaffold(
        topBar = {
            TopBarView(
                true,
                "IconButton",
                this@IconButtonPage,
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
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
                }
                IconButton(enabled = false, onClick = { /* doSomething() */ }) {
                    Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
                }
            }
        }
    )

}


