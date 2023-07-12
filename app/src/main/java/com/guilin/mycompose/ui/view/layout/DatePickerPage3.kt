package com.guilin.mycompose.ui.view.layout

import android.annotation.SuppressLint
import android.os.Build
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
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
@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavController.DatePickerPage3() {
    Scaffold(topBar = {
        TopBarView(true, "DatePicker", this@DatePickerPage3, true)
    }, content = {
        Column(
            Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val openDialog = remember { mutableStateOf(true) }
            if (openDialog.value) {
                val datePickerState = rememberDatePickerState()
                val confirmEnabled = derivedStateOf { datePickerState.selectedDateMillis != null }
                DatePickerDialog(
                    onDismissRequest = {
                        openDialog.value = false
                    }, modifier = Modifier.padding(horizontal = 20.dp),
                    confirmButton = {
                        TextButton(
                            onClick = {
                                openDialog.value = false
                                println("选中时间戳为： ${datePickerState.selectedDateMillis}")
                            },
                            enabled = confirmEnabled.value
                        ) {
                            Text("确定")
                        }
                    },
                    dismissButton = {
                        TextButton(
                            onClick = {
                                openDialog.value = false
                            }
                        ) {
                            Text("取消")
                        }
                    }
                ) {
                    DatePicker(state = datePickerState)
                }
            }
        }
    })
}