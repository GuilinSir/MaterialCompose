package com.guilin.mycompose.constant

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.guilin.mycompose.R
import com.guilin.mycompose.ui.view.layout.CenterAlignedTopAppBarPage
import com.guilin.mycompose.ui.view.MainPage
import com.guilin.mycompose.ui.view.basic.AlertdialogPage
import com.guilin.mycompose.ui.view.basic.AssistChipPage
import com.guilin.mycompose.ui.view.basic.BadgePage
import com.guilin.mycompose.ui.view.basic.ButtonPage
import com.guilin.mycompose.ui.view.basic.CardPage
import com.guilin.mycompose.ui.view.basic.CheckboxPage
import com.guilin.mycompose.ui.view.layout.BottomAppBarPage
import com.guilin.mycompose.ui.view.layout.BottomSheetScaffoldPage
import com.guilin.mycompose.ui.view.layout.CircularProgressIndicatorPage
import com.guilin.mycompose.ui.view.layout.DatePickerPage
import com.guilin.mycompose.ui.view.layout.DatePickerPage1
import com.guilin.mycompose.ui.view.layout.DatePickerPage2
import com.guilin.mycompose.ui.view.layout.DatePickerPage3
import com.guilin.mycompose.ui.view.layout.DatePickerPage4
import com.guilin.mycompose.ui.view.layout.DismissibleNavigationDrawerPage

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
            composable(NavRoute.MAIN_PAGE) { navController.MainPage() }
            composable(
                NavRoute.ALERT_DIALOG_PAGE + "/{girl_name}",
                arguments = listOf(navArgument("girl_name") {
                    type = NavType.StringType
                })
            ) { navController.AlertdialogPage(it) }
            composable(NavRoute.ASSIST_CHIP_PAGE) { navController.AssistChipPage() }
            composable(NavRoute.BADGE_PAGE) { navController.BadgePage() }
            composable(NavRoute.BUTTON_PAGE) { navController.ButtonPage() }
            composable(NavRoute.CARD_PAGE) { navController.CardPage() }
            composable(NavRoute.CHECKBOX_PAGE) { navController.CheckboxPage() }
            composable(NavRoute.FLOATING_ACTION_BUTTON_PAGE) { }
            composable(NavRoute.ICON_PAGE) { }
            composable(NavRoute.ICON_BUTTON_PAGE) { }
            composable(NavRoute.IMAGE_PAGE) { }
            composable(NavRoute.SLIDER_PAGE) { }
            composable(NavRoute.TEXT_PAGE) { }
            composable(NavRoute.TEXT_FIELD_PAGE) { }

            composable(NavRoute.BOTTOM_APP_BAR_PAGE) { navController.BottomAppBarPage() }
            composable(NavRoute.BOTTOM_SHEET_SCAFFOLD_PAGE) { navController.BottomSheetScaffoldPage() }
            composable(NavRoute.CENTER_ALIGNED_TOP_APP_BAR_PAGE) { navController.CenterAlignedTopAppBarPage() }
            composable(NavRoute.CIRCULAR_PROGRESS_INDICATOR_PAGE) { navController.CircularProgressIndicatorPage() }
            composable(NavRoute.DATE_PACKER_PAGE) { navController.DatePickerPage() }
            composable(NavRoute.DATE_PACKER_PAGE1) { navController.DatePickerPage1() }
            composable(NavRoute.DATE_PACKER_PAGE2) { navController.DatePickerPage2() }
            composable(NavRoute.DATE_PACKER_PAGE3) { navController.DatePickerPage3() }
            composable(NavRoute.DATE_PACKER_PAGE4) { navController.DatePickerPage4() }
            composable(NavRoute.DISMISSIBLE_NAVIGATION_DRAWER_PAGE) { navController.DismissibleNavigationDrawerPage() }


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

