package com.guilin.mycompose.ui.view.basic

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.guilin.mycompose.ui.wight.TopBarView

/**
 * @description:
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/7/10 2:42 PM
 */
@Composable
fun NavController.CardPage() {
    Scaffold(topBar = {
        TopBarView(true, "Card", this@CardPage, true)
    }, content = {
        Column(
            Modifier.padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)// 外边距
                    .clickable { },
                elevation = CardDefaults.cardElevation(10.dp, 10.dp, 10.dp, 10.dp, 10.dp, 10.dp)
            ) {
                Column(
                    modifier = Modifier.padding(15.dp) // 内边距
                ) {
                    Text(
                        buildAnnotatedString {
                            append("欢迎来到 ")
                            withStyle(
                                style = SpanStyle(fontWeight = FontWeight.W900)
                            ) {
                                append("Jetpack Compose")
                            }
                        }
                    )
                    Text(
                        buildAnnotatedString {
                            append("你现在观看的章节是 ")
                            withStyle(style = SpanStyle(fontWeight = FontWeight.W900)) {
                                append("Card")
                            }
                        }
                    )
                }
            }
        }
    })
}