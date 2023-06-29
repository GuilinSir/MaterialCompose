package com.guilin.mycompose.ui.view.basic

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.guilin.mycompose.ui.view.wight.TopBarView

/**
 * @description:
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/6/29 10:12 AM
 */
@Composable
fun NavController.AlertdialogPage(navBackStackEntry: NavBackStackEntry) {
    val personName = navBackStackEntry.arguments?.getString("person_name")
    personName?.let { Log.e("LookOnPage", it) }
    Column {
        TopBarView(true, "Alertdialog",this@AlertdialogPage)
        Text(text = "AlertdialogPage----$personName")
    }

}