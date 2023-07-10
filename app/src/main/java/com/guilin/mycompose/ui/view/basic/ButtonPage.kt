package com.guilin.mycompose.ui.view.basic

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.guilin.mycompose.ui.wight.TopBarView

/**
 * @description:
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/6/29 10:13 AM
 */
@Composable
fun NavController.ButtonPage() {
    val interact = remember { MutableInteractionSource() }
    val pressState = interact.collectIsPressedAsState()
    val borderColor = if (pressState.value) Color.Green else Color.Red

    Column(Modifier.fillMaxSize()) {
        TopBarView(true, "Alertdialog", this@ButtonPage, true)
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(
                enabled = false,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,//设置enabled = true是 按钮背景颜色
                    contentColor = Color.White,//设置enabled = true是 按钮内容颜色
                    disabledContainerColor = Color.Gray,//设置enabled = false 按钮背景颜色
                    disabledContentColor = Color.Black.copy(alpha = 0.2f)//设置enabled = false 按钮背景颜色
                ),
                onClick = { },
            ) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = null,
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                Text(text = "点击效果")
            }
            Button(
                onClick = { /*TODO*/ },
                border = BorderStroke(2.dp, borderColor),//边框颜色
                shape = RoundedCornerShape(
                    topStart = 5.dp,
                    topEnd = 6.dp,
                    bottomEnd = 10.dp,
                    bottomStart = 10.dp
                ),
                interactionSource = interact
            ) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = null,
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                Text(text = "确认")
            }
            Button(
                onClick = { /*TODO*/ },
                shape = CutCornerShape(8.dp, 8.dp, 8.dp, 8.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = null,
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                Text(text = "确认")
            }
        }
    }


}