package com.guilin.mycompose.ui.view.components.date_picker

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.guilin.mycompose.ui.wight.TopBarView
import kotlinx.coroutines.launch

/**
 * @description:日期选择器
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/7/12 9:11 AM
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavController.DatePickerPage4() {
    val snackState = remember { SnackbarHostState() }
    val snackScope = rememberCoroutineScope()
    SnackbarHost(hostState = snackState, Modifier.zIndex(1f))

    val state = rememberDateRangePickerState()
    Scaffold(topBar = {
        TopBarView(true, "CircularProgressIndicator", this@DatePickerPage4, true)
    }, content = {
        Column(
            Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(onClick = {  }) {
                Icon(Icons.Filled.Close, contentDescription = "Localized description")
            }
            TextButton(
                onClick = {
                    snackScope.launch {
                        snackState.showSnackbar(
                            "选择的时间戳范围: " +
                                    "${state.selectedStartDateMillis!!..state.selectedEndDateMillis!!}"
                        )
                    }
                },
                enabled = state.selectedEndDateMillis != null
            ) {
                Text(text = "保存")
            }
            DateRangePicker(state = state, modifier = Modifier.weight(1f))

        }
    })
}