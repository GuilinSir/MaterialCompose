package com.guilin.mycompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.guilin.mycompose.ui.view.main.BasicPage
import com.guilin.mycompose.ui.view.main.DesignPage
import com.guilin.mycompose.ui.view.main.LayoutPage
import com.guilin.mycompose.ui.view.main.LookOnPage
import com.guilin.mycompose.ui.view.MainPage
import com.guilin.mycompose.ui.view.basic.AlertdialogPage
import com.guilin.mycompose.ui.view.basic.ButtonPage

/**
 * @description:
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/6/29 9:30 AM
 */
class NavHost {
    @Composable
    fun MainNavigation() {
        // 创建NavController
        val navController = rememberNavController()
        // 用NavHost将NavController和导航图相关联,startDestination指定起始的可组合项
        NavHost(navController = navController, startDestination = "main_page") {
            composable("main_page") { navController.MainPage() }

            composable("alertdialog_page/{person_name}",
                arguments = listOf(navArgument("person_name") {
                    //表示传递的参数是String类型
                    type = NavType.StringType
                }
                )
            ) { navController.AlertdialogPage(it) }
            composable("button_page") { navController.ButtonPage() }

        }
    }
}



