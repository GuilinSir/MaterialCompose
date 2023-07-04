package com.guilin.mycompose.ui.view.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.guilin.mycompose.R
import com.guilin.mycompose.ui.view.wight.TopBarView

/**
 * @description:布局组件
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/6/28 3:24 PM
 */
@Composable
fun NavController.LayoutPage() {
    Surface (Modifier.fillMaxSize()){
        Column {
            TopBarView(false, stringResource(R.string.second_tab_title), this@LayoutPage, true)
            Text(text = "LayoutPage")
        }
    }
}