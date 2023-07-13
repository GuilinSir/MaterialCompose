package com.guilin.mycompose.ui.view.components.bottom_sheet

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.guilin.mycompose.ui.wight.TopBarView
import kotlinx.coroutines.launch

/**
 * @description:BottomSheetScaffold页面
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/7/10 3:22 PM
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavController.BottomSheetScaffoldPage() {
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState()
    Scaffold(topBar = {
        TopBarView(true, "BottomSheetScaffold", this@BottomSheetScaffoldPage, true)
    }, content = {
        Column(
            Modifier.padding(it).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    scope.launch {
                        if (scaffoldState.bottomSheetState.currentValue == SheetValue.PartiallyExpanded) {
                            scaffoldState.bottomSheetState.expand()
                        } else if (scaffoldState.bottomSheetState.currentValue == SheetValue.Expanded) {
                            scaffoldState.bottomSheetState.partialExpand()
                        }
                    }
                }
            ) {
                if (scaffoldState.bottomSheetState.currentValue == SheetValue.PartiallyExpanded) {
                    Text("Click to Expanded sheet")
                } else if (scaffoldState.bottomSheetState.currentValue == SheetValue.Expanded) {
                    Text("Click to PartiallyExpanded sheet")
                }
            }
            BottomSheetScaffold(
                scaffoldState = scaffoldState,
                sheetPeekHeight = 50.dp,
                sheetContent = {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Swipe up to expand sheet")
                    }
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .padding(64.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Sheet content")
                        Spacer(Modifier.height(20.dp))
                        Button(
                            onClick = {
                                scope.launch { scaffoldState.bottomSheetState.partialExpand() }
                            }
                        ) {
                            Text("Click to collapse sheet")
                        }
                    }
                }) { innerPadding ->
                Box(Modifier.padding(innerPadding)) {
                    Text("Scaffold Content")
                }
            }
        }
    })
}