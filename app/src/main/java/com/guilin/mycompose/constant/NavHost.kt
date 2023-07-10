package com.guilin.mycompose.constant

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.guilin.mycompose.R
import com.guilin.mycompose.ui.view.MainPage
import com.guilin.mycompose.ui.view.basic.AlertdialogPage
import com.guilin.mycompose.ui.view.basic.AssistChipPage
import com.guilin.mycompose.ui.view.basic.BadgePage
import com.guilin.mycompose.ui.view.basic.ButtonPage
import com.guilin.mycompose.ui.view.basic.CardPage

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
            composable(
                "alertdialog_page/{girl_name}",
                arguments = listOf(navArgument("girl_name") {
                    type = NavType.StringType
                })
            ) { navController.AlertdialogPage(it) }
            composable("assist_chip_page") { navController.AssistChipPage() }
            composable("badge_page") { navController.BadgePage() }
            composable("button_page") { navController.ButtonPage() }
            composable("card_page") { navController.CardPage() }
            composable("floating_action_button_page") { }
            composable("icon_page") { }
            composable("icon_button_page") { }
            composable("image_page") { }
            composable("slider_page") { }
            composable("text_page") { }
            composable("text_field_page") { }


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

