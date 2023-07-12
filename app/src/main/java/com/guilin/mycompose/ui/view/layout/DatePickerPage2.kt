package com.guilin.mycompose.ui.view.layout

import android.os.Build
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.guilin.mycompose.ui.wight.TopBarView
import java.time.DayOfWeek
import java.time.Instant
import java.time.ZoneId
import java.util.Calendar
import java.util.TimeZone

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
fun NavController.DatePickerPage2() {
    val datePickerState = rememberDatePickerState(
        //需要Compose Material3 1.2.0-alpha02以上版本
        //SelectableDates具有阻止选择某些日期的提供的 DatePicker如下所示：
        selectableDates = object : SelectableDates {
            // Blocks Sunday and Saturday from being selected.
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    val dayOfWeek = Instant.ofEpochMilli(utcTimeMillis).atZone(ZoneId.of("UTC"))
                        .toLocalDate().dayOfWeek
                    dayOfWeek != DayOfWeek.SUNDAY && dayOfWeek != DayOfWeek.SATURDAY
                } else {
                    val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
                    calendar.timeInMillis = utcTimeMillis
                    calendar[Calendar.DAY_OF_WEEK] != Calendar.SUNDAY &&
                            calendar[Calendar.DAY_OF_WEEK] != Calendar.SATURDAY
                }
            }

            // Allow selecting dates from year 2023 forward.
            override fun isSelectableYear(year: Int): Boolean {
                return year > 2022
            }
        }
    )
    Scaffold(topBar = {
        TopBarView(true, "DatePicker", this@DatePickerPage2, true)
    }, content = {
        Column(
            Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DatePicker(state = datePickerState)
            Text("Selected date timestamp: ${datePickerState.selectedDateMillis ?: "no selection"}")


        }
    })
}