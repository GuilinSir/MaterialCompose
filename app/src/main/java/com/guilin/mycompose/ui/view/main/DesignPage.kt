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
import com.guilin.mycompose.ui.wight.TopBarView

/**
 * @description:设计
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/6/28 3:26 PM
 */
@Composable
fun NavController.DesignPage() {
    Surface (Modifier.fillMaxSize()){
        Column {
            TopBarView(false, stringResource(R.string.third_tab_title), this@DesignPage,true)
            Text(text = "DesignPage")
        }

    }

}