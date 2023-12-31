package com.guilin.mycompose.constant

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.guilin.mycompose.R
import com.guilin.mycompose.ui.view.components.top_app_bar.CenterAlignedTopAppBarPage
import com.guilin.mycompose.ui.view.MainPage
import com.guilin.mycompose.ui.view.components.FAB.FloatingActionButtonPage
import com.guilin.mycompose.ui.view.components.FAB.LargeFloatingActionButtonPage
import com.guilin.mycompose.ui.view.components.FAB.SmallFloatingActionButtonPage
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
import com.guilin.mycompose.ui.view.components.navigation_drawer.DismissibleNavigationDrawerPage
import com.guilin.mycompose.ui.view.components.badge.BadgedBoxPage
import com.guilin.mycompose.ui.view.components.bottom_sheet.ModalBottomSheetPage
import com.guilin.mycompose.ui.view.components.buttons.ElevatedButtonPage
import com.guilin.mycompose.ui.view.components.buttons.FilledTonalButtonPage
import com.guilin.mycompose.ui.view.components.buttons.OutlinedButtonPage
import com.guilin.mycompose.ui.view.components.buttons.TextButtonPage
import com.guilin.mycompose.ui.view.components.cards.ElevatedCardPage
import com.guilin.mycompose.ui.view.components.cards.OutlinedCardPaged
import com.guilin.mycompose.ui.view.components.checkbox.TriStateCheckboxPage
import com.guilin.mycompose.ui.view.components.chips.ElevatedAssistChipPage
import com.guilin.mycompose.ui.view.components.chips.ElevatedFilterChipPage
import com.guilin.mycompose.ui.view.components.chips.ElevatedSuggestionChipPage
import com.guilin.mycompose.ui.view.components.chips.FilterChipPage
import com.guilin.mycompose.ui.view.components.chips.InputChipPage
import com.guilin.mycompose.ui.view.components.chips.SuggestionChipPage
import com.guilin.mycompose.ui.view.components.date_picker.DatePickerDialogPage
import com.guilin.mycompose.ui.view.components.date_picker.DateRangePickerPage
import com.guilin.mycompose.ui.view.components.dividers.DividerPage
import com.guilin.mycompose.ui.view.components.extended_FAB.ExtendedFloatingActionButtonPage
import com.guilin.mycompose.ui.view.components.icon_button.FilledIconButtonPage
import com.guilin.mycompose.ui.view.components.icon_button.FilledIconToggleButtonPage
import com.guilin.mycompose.ui.view.components.icon_button.FilledTonalIconButtonPage
import com.guilin.mycompose.ui.view.components.icon_button.FilledTonalIconToggleButtonPage
import com.guilin.mycompose.ui.view.components.icon_button.IconButtonPage
import com.guilin.mycompose.ui.view.components.icon_button.IconToggleButtonPage
import com.guilin.mycompose.ui.view.components.icon_button.OutlinedIconButtonPage
import com.guilin.mycompose.ui.view.components.icon_button.OutlinedIconToggleButtonPage
import com.guilin.mycompose.ui.view.components.lists.ListItemPage
import com.guilin.mycompose.ui.view.components.menus.DropdownMenuPage
import com.guilin.mycompose.ui.view.components.menus.ExposedDropdownMenuBoxPage
import com.guilin.mycompose.ui.view.components.navigation_bar.NavigationBarPage
import com.guilin.mycompose.ui.view.components.navigation_drawer.ModalNavigationDrawerPage
import com.guilin.mycompose.ui.view.components.navigation_drawer.PermanentNavigationDrawerPage
import com.guilin.mycompose.ui.view.components.navigation_rail.NavigationRailPage
import com.guilin.mycompose.ui.view.components.progress_indicators.LinearProgressIndicatorPage
import com.guilin.mycompose.ui.view.components.radio_button.RadioButtonPage
import com.guilin.mycompose.ui.view.components.search_bar.DockedSearchBarPage
import com.guilin.mycompose.ui.view.components.search_bar.SearchBarPage
import com.guilin.mycompose.ui.view.components.sliders.RangeSliderPage
import com.guilin.mycompose.ui.view.components.sliders.SliderPage
import com.guilin.mycompose.ui.view.components.snackbars.SnackBarPage

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
            composable(NavRoute.TRI_STATE_CHECKBOX_PAGE) { navController.TriStateCheckboxPage() }



            composable(NavRoute.ASSIST_CHIP_PAGE) { navController.AssistChipPage() }
            composable(NavRoute.ELEVATED_ASSIST_CHIP) { navController.ElevatedAssistChipPage() }
            composable(NavRoute.FILTER_CHIP) { navController.FilterChipPage() }
            composable(NavRoute.ELEVATED_FILTER_CHIP) { navController.ElevatedFilterChipPage() }
            composable(NavRoute.INPUT_CHIP) { navController.InputChipPage() }
            composable(NavRoute.SUGGESTION_CHIP) { navController.SuggestionChipPage() }
            composable(NavRoute.ELEVATED_SUGGESTION_CHIP) { navController.ElevatedSuggestionChipPage() }


            composable(NavRoute.DATE_PACKER_PAGE) { navController.DatePickerPage() }
            composable(NavRoute.DATE_PACKER_PAGE1) { navController.DatePickerPage1() }
            composable(NavRoute.DATE_PACKER_PAGE2) { navController.DatePickerPage2() }
            composable(NavRoute.DATE_PACKER_DIALOG_PAGE) { navController.DatePickerDialogPage() }
            composable(NavRoute.DATE_RANGE_PACKER_PAGE) { navController.DateRangePickerPage() }

            composable(NavRoute.ALERT_DIALOG_PAGE) { navController.AlertdialogPage(it) }

            composable(NavRoute.DIVIDERS_PAGE) { navController.DividerPage() }

            composable(NavRoute.EXTENDED_FLOATING_ACTION_BUTTON_PAGE) { navController.ExtendedFloatingActionButtonPage() }

            composable(NavRoute.FLOATING_ACTION_BUTTON_PAGE) {
                navController.FloatingActionButtonPage()
            }
            composable(NavRoute.SMALL_FLOATING_ACTION_BUTTON_PAGE) {
                navController.SmallFloatingActionButtonPage()
            }
            composable(NavRoute.LARGE_FLOATING_ACTION_BUTTON_PAGE) {
                navController.LargeFloatingActionButtonPage()
            }

            composable(NavRoute.ICON_BUTTON_PAGE) {
                navController.IconButtonPage()
            }
            composable(NavRoute.ICON_TOGGLE_BUTTON_PAGE) {
                navController.IconToggleButtonPage()
            }
            composable(NavRoute.FILLED_ICON_BUTTON_PAGE) {
                navController.FilledIconButtonPage()
            }
            composable(NavRoute.FILLED_ICON_TOGGLE_BUTTON_PAGE) {
                navController.FilledIconToggleButtonPage()
            }
            composable(NavRoute.FILLED_TONAL_ICON_BUTTON_PAGE) {
                navController.FilledTonalIconButtonPage()
            }
            composable(NavRoute.FILLED_TONAL_ICON_TOGGLE_BUTTON_PAGE) {
                navController.FilledTonalIconToggleButtonPage()
            }
            composable(NavRoute.OUTLINED_ICON_BUTTON_PAGE) {
                navController.OutlinedIconButtonPage()
            }
            composable(NavRoute.OUTLINED_ICON_TOGGLE_BUTTON_PAGE) {
                navController.OutlinedIconToggleButtonPage()
            }

            composable(NavRoute.LIST_ITEM_PAGE) {
                navController.ListItemPage()
            }

            composable(NavRoute.DROPDOWN_MENU_PAGE) {
                navController.DropdownMenuPage()
            }
            composable(NavRoute.EXPOSED_DROPDOWN_MENU_BOX_PAGE) { navController.ExposedDropdownMenuBoxPage() }
            composable(NavRoute.NAVIGATION_BAR_PAGE) { navController.NavigationBarPage() }
            composable(NavRoute.NAVIGATION_BAR_ITEM_PAGE) { navController.NavigationBarPage() }


            composable(NavRoute.MODAL_NAVIGATION_DRAWER_PAGE) { navController.ModalNavigationDrawerPage() }
            composable(NavRoute.MODAL_DRAWER_SHEET_PAGE) { navController.ModalNavigationDrawerPage() }
            composable(NavRoute.PERMANENT_NAVIGATION_DRAWER_PAGE) { navController.PermanentNavigationDrawerPage() }
            composable(NavRoute.PERMANENT_DRAWER_SHEET_PAGE) { navController.PermanentNavigationDrawerPage() }

            composable(NavRoute.DISMISSIBLE_NAVIGATION_DRAWER_PAGE) { navController.DismissibleNavigationDrawerPage() }
            composable(NavRoute.DISMISSIBLE_DRAWER_SHEET_PAGE) { navController.DismissibleNavigationDrawerPage() }
            composable(NavRoute.NAVIGATION_DRAWER_ITEM_PAGE) {
                navController.ModalNavigationDrawerPage()
            }

            composable(NavRoute.NAVIGATION_RAIL_PAGE) {
                navController.NavigationRailPage()
            }
            composable(NavRoute.NAVIGATION_RAIL_ITEM_PAGE) {
                navController.NavigationRailPage()
            }

            composable(NavRoute.LINEAR_PROGRESS_INDICATOR_PAGE) { navController.LinearProgressIndicatorPage() }
            composable(NavRoute.CIRCULAR_PROGRESS_INDICATOR_PAGE) { navController.CircularProgressIndicatorPage() }

            composable(NavRoute.RADIO_BUTTON_PAGE) { navController.RadioButtonPage() }

            composable(NavRoute.SEARCH_BAR_PAGE) { navController.SearchBarPage() }
            composable(NavRoute.DOCKED_SEARCH_BAR_PAGE) { navController.DockedSearchBarPage() }

            composable(NavRoute.SLIDER_PAGE) {
                navController.SliderPage()
            }
            composable(NavRoute.RANGE_SLIDER_PAGE) {
                navController.RangeSliderPage()
            }

            composable(NavRoute.SNACK_BAR_PAGE) {
                navController.SnackBarPage()
            }

            composable(NavRoute.TEXT_FIELD_PAGE) { }
            composable(NavRoute.CENTER_ALIGNED_TOP_APP_BAR_PAGE) { navController.CenterAlignedTopAppBarPage() }
        }
    }


    fun componentsClickEvent(item: String, navController: NavController) {
        when (item) {
            "Badge" -> NavHost().navigate(navController, NavRoute.BADGE_PAGE)
            "BadgedBox" -> NavHost().navigate(navController, NavRoute.BADGED_BOX_PAGE)

            "BottomAppBar" -> NavHost().navigate(
                navController,
                NavRoute.BOTTOM_APP_BAR_PAGE
            )

            "BottomSheetScaffold" -> NavHost().navigate(
                navController,
                NavRoute.BOTTOM_SHEET_SCAFFOLD_PAGE
            )

            "ModalBottomSheet" -> NavHost().navigate(
                navController,
                NavRoute.MODAL_BOTTOM_SHEET_PAGE
            )

            "Button" -> NavHost().navigate(navController, NavRoute.BUTTON_PAGE)
            "ElevatedButton" -> NavHost().navigate(navController, NavRoute.ELEVATED_BUTTON_PAGE)
            "FilledTonalButton" -> NavHost().navigate(
                navController,
                NavRoute.FILLED_TONAL_BUTTON_PAGE
            )

            "OutlinedButton" -> NavHost().navigate(navController, NavRoute.OUTLINED_BUTTON_PAGE)
            "TextButton" -> NavHost().navigate(navController, NavRoute.TEXT_BUTTON_PAGE)

            "Card" -> NavHost().navigate(navController, NavRoute.CARD_PAGE)
            "ElevatedCard" -> NavHost().navigate(navController, NavRoute.ELEVATED_CARD_PAGE)
            "OutlinedCard" -> NavHost().navigate(navController, NavRoute.OUTLINED_CARD_PAGE)

            "Checkbox" -> NavHost().navigate(navController, NavRoute.CHECKBOX_PAGE)
            "TriStateCheckbox" -> NavHost().navigate(
                navController,
                NavRoute.TRI_STATE_CHECKBOX_PAGE
            )

            "AssistChip" -> NavHost().navigate(navController, NavRoute.ASSIST_CHIP_PAGE)
            "ElevatedAssistChip" -> NavHost().navigate(navController, NavRoute.ELEVATED_ASSIST_CHIP)
            "FilterChip" -> NavHost().navigate(navController, NavRoute.FILTER_CHIP)
            "ElevatedFilterChip" -> NavHost().navigate(navController, NavRoute.ELEVATED_FILTER_CHIP)
            "InputChip" -> NavHost().navigate(navController, NavRoute.INPUT_CHIP)
            "SuggestionChip" -> NavHost().navigate(navController, NavRoute.SUGGESTION_CHIP)
            "ElevatedSuggestionChip" -> NavHost().navigate(
                navController,
                NavRoute.ELEVATED_SUGGESTION_CHIP
            )

            "DatePicker" -> NavHost().navigate(
                navController,
                NavRoute.DATE_PACKER_PAGE
            )

            "DatePickerDialog" -> NavHost().navigate(
                navController,
                NavRoute.DATE_PACKER_DIALOG_PAGE
            )

            "DateRangePicker" -> NavHost().navigate(
                navController,
                NavRoute.DATE_RANGE_PACKER_PAGE
            )

            "AlertDialog" -> NavHost().navigate(
                navController,
                NavRoute.ALERT_DIALOG_PAGE
            )

            "Dividers" -> NavHost().navigate(
                navController,
                NavRoute.DIVIDERS_PAGE
            )

            "ExtendedFloatingActionButton" -> NavHost().navigate(
                navController,
                NavRoute.EXTENDED_FLOATING_ACTION_BUTTON_PAGE
            )

            "FloatingActionButton" -> NavHost().navigate(
                navController,
                NavRoute.FLOATING_ACTION_BUTTON_PAGE
            )

            "SmallFloatingActionButton" -> NavHost().navigate(
                navController,
                NavRoute.SMALL_FLOATING_ACTION_BUTTON_PAGE
            )

            "LargeFloatingActionButton" -> NavHost().navigate(
                navController,
                NavRoute.LARGE_FLOATING_ACTION_BUTTON_PAGE
            )

            "IconButton" -> NavHost().navigate(navController, NavRoute.ICON_BUTTON_PAGE)
            "IconToggleButton" -> NavHost().navigate(
                navController,
                NavRoute.ICON_TOGGLE_BUTTON_PAGE
            )

            "FilledIconButton" -> NavHost().navigate(
                navController,
                NavRoute.FILLED_ICON_BUTTON_PAGE
            )

            "FilledIconToggleButton" -> NavHost().navigate(
                navController,
                NavRoute.FILLED_ICON_TOGGLE_BUTTON_PAGE
            )

            "FilledTonalIconButton" -> NavHost().navigate(
                navController,
                NavRoute.FILLED_TONAL_ICON_BUTTON_PAGE
            )

            "FilledTonalIconToggleButton" -> NavHost().navigate(
                navController,
                NavRoute.FILLED_TONAL_ICON_TOGGLE_BUTTON_PAGE
            )

            "OutlinedIconButton" -> NavHost().navigate(
                navController,
                NavRoute.OUTLINED_ICON_BUTTON_PAGE
            )

            "OutlinedIconToggleButton" -> NavHost().navigate(
                navController,
                NavRoute.OUTLINED_ICON_TOGGLE_BUTTON_PAGE
            )

            "ListItem" -> NavHost().navigate(
                navController,
                NavRoute.LIST_ITEM_PAGE
            )

            "DropdownMenu" -> NavHost().navigate(
                navController,
                NavRoute.DROPDOWN_MENU_PAGE
            )

            "DropdownMenuItem" -> NavHost().navigate(
                navController,
                NavRoute.DROPDOWN_MENU_PAGE
            )

            "ExposedDropdownMenuBox" -> NavHost().navigate(
                navController,
                NavRoute.EXPOSED_DROPDOWN_MENU_BOX_PAGE
            )

            "NavigationBar" -> NavHost().navigate(
                navController,
                NavRoute.NAVIGATION_BAR_PAGE
            )

            "NavigationBarItem" -> NavHost().navigate(
                navController,
                NavRoute.NAVIGATION_BAR_ITEM_PAGE
            )

            "ModalNavigationDrawer" -> NavHost().navigate(
                navController,
                NavRoute.MODAL_NAVIGATION_DRAWER_PAGE
            )

            "ModalDrawerSheet" -> NavHost().navigate(
                navController,
                NavRoute.MODAL_DRAWER_SHEET_PAGE
            )

            "PermanentNavigationDrawer" -> NavHost().navigate(
                navController,
                NavRoute.PERMANENT_NAVIGATION_DRAWER_PAGE
            )

            "PermanentDrawerSheet" -> NavHost().navigate(
                navController,
                NavRoute.PERMANENT_DRAWER_SHEET_PAGE
            )

            "DismissibleNavigationDrawer" -> NavHost().navigate(
                navController,
                NavRoute.DISMISSIBLE_NAVIGATION_DRAWER_PAGE
            )

            "DismissibleDrawerSheet" -> NavHost().navigate(
                navController,
                NavRoute.DISMISSIBLE_DRAWER_SHEET_PAGE
            )

            "NavigationDrawerItem" -> NavHost().navigate(
                navController,
                NavRoute.NAVIGATION_DRAWER_ITEM_PAGE
            )


            "NavigationRail" -> NavHost().navigate(
                navController,
                NavRoute.NAVIGATION_RAIL_PAGE
            )

            "NavigationRailItem" -> NavHost().navigate(
                navController,
                NavRoute.NAVIGATION_RAIL_ITEM_PAGE
            )

            "LinearProgressIndicator" -> NavHost().navigate(
                navController,
                NavRoute.LINEAR_PROGRESS_INDICATOR_PAGE
            )

            "CircularProgressIndicator" -> NavHost().navigate(
                navController,
                NavRoute.CIRCULAR_PROGRESS_INDICATOR_PAGE
            )

            "RadioButton" -> NavHost().navigate(
                navController,
                NavRoute.RADIO_BUTTON_PAGE
            )

            "SearchBar" -> NavHost().navigate(
                navController,
                NavRoute.SEARCH_BAR_PAGE
            )

            "DockedSearchBar" -> NavHost().navigate(
                navController,
                NavRoute.DOCKED_SEARCH_BAR_PAGE
            )

            "Slider" -> NavHost().navigate(navController, NavRoute.SLIDER_PAGE)
            "RangeSlider" -> NavHost().navigate(navController, NavRoute.RANGE_SLIDER_PAGE)

            "Snackbar" ->NavHost().navigate(navController, NavRoute.SNACK_BAR_PAGE)

            "TextField" -> NavHost().navigate(navController, NavRoute.TEXT_FIELD_PAGE)

            "CenterAlignedTopAppBar" -> NavHost().navigate(
                navController,
                NavRoute.CENTER_ALIGNED_TOP_APP_BAR_PAGE
            )
        }
    }

    private fun navigate(navController: NavController, route: String) {
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

