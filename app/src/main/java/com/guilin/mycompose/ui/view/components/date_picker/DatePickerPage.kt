package com.guilin.mycompose.ui.view.components.date_picker

import android.os.Build
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.guilin.mycompose.constant.NavRoute
import com.guilin.mycompose.ui.wight.TopBarView

/**
 * @description:日期选择器
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/7/12 9:11 AM
 *
 *@ExperimentalMaterial3Api
 * @Composable
 * fun DatePicker(
 *     state: DatePickerState,
 *     modifier: Modifier = Modifier,
 *     dateFormatter: DatePickerFormatter = remember { DatePickerDefaults.dateFormatter() },
 *     title: (@Composable () -> Unit)? = {
 *         DatePickerDefaults.DatePickerTitle(
 *             displayMode = state.displayMode,
 *             modifier = Modifier.padding(DatePickerTitlePadding)
 *         )
 *     },
 *     headline: (@Composable () -> Unit)? = {
 *         DatePickerDefaults.DatePickerHeadline(
 *             selectedDateMillis = state.selectedDateMillis,
 *             displayMode = state.displayMode,
 *             dateFormatter = dateFormatter,
 *             modifier = Modifier.padding(DatePickerHeadlinePadding)
 *         )
 *     },
 *     showModeToggle: Boolean = true,
 *     colors: DatePickerColors = DatePickerDefaults.colors()
 * ): Unit
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavController.DatePickerPage() {
    Scaffold(topBar = {
        TopBarView(true, "DatePicker", this@DatePickerPage, true)
    }, content = {
        Column(
            Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                navigate(NavRoute.DATE_PACKER_PAGE1)
            }) {
                Text(text = "Normal Date Picker")
            }
            Button(onClick = {
                navigate(NavRoute.DATE_PACKER_PAGE2)
            }) {
                Text(text = "Prohibit Selecting Dates")
            }
        }
    })
}