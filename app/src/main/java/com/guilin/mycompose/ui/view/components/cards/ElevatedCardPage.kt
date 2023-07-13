package com.guilin.mycompose.ui.view.components.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
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
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavController.ElevatedCardPage() {
    Scaffold(topBar = {
        TopBarView(true, "ElevatedCard", this@ElevatedCardPage, true)
    }, content = {
        Column(
            Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ElevatedCard(
                onClick = {},
                modifier = Modifier
                    .size(width = 240.dp, height = 180.dp)
            ) {
                Column(
                    modifier = Modifier.padding(15.dp) // 内边距
                ) {
                    Text(
                        buildAnnotatedString {
                            append("Welcome ")
                            withStyle(
                                style = SpanStyle(fontWeight = FontWeight.W900)
                            ) {
                                append("Jetpack Compose")
                            }
                        }
                    )
                    Text(
                        buildAnnotatedString {
                            append("The chapter you are currently viewing is ")
                            withStyle(style = SpanStyle(fontWeight = FontWeight.W900)) {
                                append("ElevatedCard")
                            }
                        }
                    )
                }
            }
        }
    })
}