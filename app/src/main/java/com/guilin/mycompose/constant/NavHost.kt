package com.guilin.mycompose.constant

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.guilin.mycompose.R
import com.guilin.mycompose.ui.view.components.top_app_bar.CenterAlignedTopAppBarPage
import com.guilin.mycompose.ui.view.MainPage
import com.guilin.mycompose.ui.view.components.dialogs.AlertdialogPage
import com.guilin.mycompose.ui.view.components.chips.AssistChipPage
import com.guilin.mycompose.ui.view.components.badge.BadgePage
import com.guilin.mycompose.ui.view.components.buttons.ButtonPage
import com.guilin.mycompose.ui.view.components.cards.CardPage
import com.guilin.mycompose.ui.view.components.checkbox.CheckboxPage
import com.guilin.mycompose.ui.view.components.bottom_app_bar.BottomAppBarPage
import com.guilin.mycompose.ui.view.components.bottom_sheet.BottomSheetScaffoldPage
import com.guilin.mycompose.ui.view.components.progress_indicators.CircularProgressIndicatorPage
import com.guilin.mycompose.ui.view.components.date_picker.DatePickerPage
import com.guilin.mycompose.ui.view.components.date_picker.DatePickerPage1
import com.guilin.mycompose.ui.view.components.date_picker.DatePickerPage2
import com.guilin.mycompose.ui.view.components.date_picker.DatePickerPage3
import com.guilin.mycompose.ui.view.components.date_picker.DatePickerPage4
import com.guilin.mycompose.ui.view.components.navigation_drawer.DismissibleNavigationDrawerPage
import com.guilin.mycompose.ui.view.components.badge.BadgedBoxPage
import com.guilin.mycompose.ui.view.components.bottom_sheet.ModalBottomSheetPage
import com.guilin.mycompose.ui.view.components.buttons.ElevatedButtonPage
import com.guilin.mycompose.ui.view.components.buttons.FilledTonalButtonPage
import com.guilin.mycompose.ui.view.components.buttons.OutlinedButtonPage
import com.guilin.mycompose.ui.view.components.buttons.TextButtonPage
import com.guilin.mycompose.ui.view.components.cards.ElevatedCardPage
import com.guilin.mycompose.ui.view.components.cards.OutlinedCardPaged

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
        ) {
            composable(NavRoute.MAIN_PAGE) { navController.MainPage() }
            composable(NavRoute.BADGE_PAGE) { navController.BadgePage() }
            composable(NavRoute.BADGED_BOX_PAGE) { navController.BadgedBoxPage() }
            composable(NavRoute.BOTTOM_APP_BAR_PAGE) { navController.BottomAppBarPage() }
            composable(NavRoute.BOTTOM_SHEET_SCAFFOLD_PAGE) { navController.BottomSheetScaffoldPage() }
            composable(NavRoute.MODAL_BOTTOM_SHEET_PAGE) { navController.ModalBottomSheetPage() }
            composable(NavRoute.BUTTON_PAGE) { navController.ButtonPage() }
            composable(NavRoute.ELEVATED_BUTTON_PAGE) { navController.ElevatedButtonPage() }
            composable(NavRoute.FILLED_TONAL_BUTTON_PAGE) { navController.FilledTonalButtonPage() }
            composable(NavRoute.OUTLINED_BUTTON_PAGE) { navController.OutlinedButtonPage() }
            composable(NavRoute.TEXT_BUTTON_PAGE) { navController.TextButtonPage() }


            composable(NavRoute.CARD_PAGE) { navController.CardPage() }
            composable(NavRoute.ELEVATED_CARD_PAGE) { navController.ElevatedCardPage() }
            composable(NavRoute.OUTLINED_CARD_PAGE) { navController.OutlinedCardPaged() }


            composable(NavRoute.CHECKBOX_PAGE) { navController.CheckboxPage() }
            composable(NavRoute.ASSIST_CHIP_PAGE) { navController.AssistChipPage() }
            composable(NavRoute.DATE_PACKER_PAGE) { navController.DatePickerPage() }
            composable(NavRoute.DATE_PACKER_PAGE1) { navController.DatePickerPage1() }
            composable(NavRoute.DATE_PACKER_PAGE2) { navController.DatePickerPage2() }
            composable(NavRoute.DATE_PACKER_PAGE3) { navController.DatePickerPage3() }
            composable(NavRoute.DATE_PACKER_PAGE4) { navController.DatePickerPage4() }
            composable(NavRoute.ALERT_DIALOG_PAGE) { navController.AlertdialogPage(it) }
            composable(NavRoute.FLOATING_ACTION_BUTTON_PAGE) { }
            composable(NavRoute.ICON_BUTTON_PAGE) { }
            composable(NavRoute.DISMISSIBLE_NAVIGATION_DRAWER_PAGE) { navController.DismissibleNavigationDrawerPage() }
            composable(NavRoute.CIRCULAR_PROGRESS_INDICATOR_PAGE) { navController.CircularProgressIndicatorPage() }
            composable(NavRoute.SLIDER_PAGE) { }
            composable(NavRoute.TEXT_FIELD_PAGE) { }
            composable(NavRoute.CENTER_ALIGNED_TOP_APP_BAR_PAGE) { navController.CenterAlignedTopAppBarPage() }
        }
    }

    fun navigate(navController: NavController, route: String) {
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

