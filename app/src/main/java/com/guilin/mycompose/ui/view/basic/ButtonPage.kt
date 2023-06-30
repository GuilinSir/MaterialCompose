package com.guilin.mycompose.ui.view.basic

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.guilin.mycompose.ui.view.wight.TopBarView

/**
 * @description:
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/6/29 10:13 AM
 */
@Composable
fun NavController.ButtonPage() {
    Column {
        TopBarView(true, "Alertdialog", this@ButtonPage,true)
        Text(text = "ButtonPage")
    }
}