package com.guilin.mycompose

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    fun MainNavigation() {
        // 创建NavController
        val navController = rememberNavController()
        // 用NavHost将NavController和导航图相关联,startDestination指定起始的可组合项
        NavHost(
            navController = navController,
            startDestination = "main_page",
//            enterTransition = {
//                slideInHorizontally(
//                    initialOffsetX = { fullWidth -> fullWidth },
//                    animationSpec = tween(500)
//                )
//            },
//            exitTransition = {
//                slideOutHorizontally(
//                    targetOffsetX = { fullWidth -> fullWidth },
//                    animationSpec = tween(500)
//                )
//            },
//            popEnterTransition = {
//                slideInHorizontally(
//                    initialOffsetX = { fullWidth -> fullWidth },
//                    animationSpec = tween(500)
//                )
//            },
//            popExitTransition = {
//                slideOutHorizontally(
//                    targetOffsetX = { fullWidth -> fullWidth },
//                    animationSpec = tween(500)
//                )
//            }
        ) {
            composable("main_page") { navController.MainPage() }
            //带参数
            composable("alertdialog_page/{girl_name}",
                arguments = listOf(navArgument("girl_name") {
                    type = NavType.StringType
                }
                )
            ) { navController.AlertdialogPage(it) }
            composable("button_page") { navController.ButtonPage() }

        }
    }

    fun Navigate(navController: NavController, route: String) {
        navController.navigate(route) {
            anim {
                this.enter = R.anim.slide_in_right
                this.exit = R.anim.slide_out_left
                this.popEnter = R.anim.slide_in_left
                this.popExit = R.anim.slide_out_right
            }
        }
    }

}

