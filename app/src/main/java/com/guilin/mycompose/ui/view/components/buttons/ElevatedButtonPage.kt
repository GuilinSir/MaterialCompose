package com.guilin.mycompose.ui.view.components.buttons

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.guilin.mycompose.ui.wight.TopBarView

/**
 * @description:悬浮按钮
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/6/29 10:13 AM
 */
@Composable
fun NavController.ElevatedButtonPage() {
    val interact = remember { MutableInteractionSource() }
    val pressState = interact.collectIsPressedAsState()
    val borderColor = if (pressState.value) Color.Green else Color.Red

    Scaffold(topBar = {
        TopBarView(true, "ElevatedButton", this@ElevatedButtonPage, true)
    }, content = {
        Column(
            Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ElevatedButton(onClick = { /* Do something! */ }) { Text("Elevated Button") }
        }
    })
}