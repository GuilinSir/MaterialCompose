package com.guilin.mycompose.ui.view.basic

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.guilin.common.constant.SpKey
import com.guilin.mycompose.R
import com.guilin.mycompose.enum.ThemeEnum
import com.guilin.mycompose.ui.theme.themeTypeState
import com.guilin.mycompose.ui.view.main.ThemeListView
import com.guilin.mycompose.ui.view.main.ThemePage
import com.guilin.mycompose.ui.view.main.themeList
import com.guilin.mycompose.ui.wight.TopBarView

/**
 * @description:
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/6/29 10:12 AM
 *
 * @Composable
 *     fun AlertDialog(
 *     onDismissRequest: () -> Unit,
 *     confirmButton: () -> Unit,
 *     modifier: Modifier = Modifier,
 *     dismissButton: () -> Unit = null,
 *     title: () -> Unit = null,
 *     text: () -> Unit = null,
 *     shape: Shape = MaterialTheme.shapes.medium,
 *     backgroundColor: Color = MaterialTheme.colors.surface,
 *     contentColor: Color = contentColorFor(backgroundColor),
 *     properties: DialogProperties = DialogProperties()
 *     ): @Composable Unit
 */
@Composable
fun NavController.AlertdialogPage(navBackStackEntry: NavBackStackEntry) {
    //测试传参
    val personName = navBackStackEntry.arguments?.getString("girl_name")
    //personName?.let { Log.e("AlertdialogPage", it) }

    val openDialog = remember {
        mutableStateOf(false)
    }
    val openDialog2 = remember {
        mutableStateOf(false)
    }
    Scaffold(topBar = {
        TopBarView(true, "Alertdialog", this@AlertdialogPage, true)
    }, content = {
        Column(Modifier.padding(it).fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = {
                    openDialog.value = true
                }) {
                    Text(text = "样式一")
                }
                Button(onClick = {
                    openDialog2.value = true
                }) {
                    Text(text = "样式二")
                }
                AlertDialog(openDialog)
                AlertDialog2(openDialog2)

            }
    })

}

@Composable
fun AlertDialog(openDialog: MutableState<Boolean>) {
    if (openDialog.value) {
        AlertDialog(
            shape = RoundedCornerShape(6.dp),
            onDismissRequest = {
                // 当用户点击对话框以外的地方或者按下系统返回键将会执行的代码
                openDialog.value = false
            },
            title = {
                Text(
                    text = "开启位置服务",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center)

                )
            },
            text = {
                Text(
                    text = "这将意味着，我们会给您提供精准的位置服务，并且您将接受关于您订阅的位置信息",
                    fontSize = 14.sp
                )

            },
            confirmButton = {
                TextButton(
                    onClick = { openDialog.value = false },
                    colors = ButtonDefaults.buttonColors(
                        MaterialTheme.colorScheme.primary
                    ),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(
                        text = "确认",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W700,
                        color = MaterialTheme.colorScheme.onPrimary
                    )

                }
            },
            dismissButton = {
                TextButton(
                    onClick = { openDialog.value = false },
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(
                        text = "取消",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W700,

                        )

                }
            }

        )
    }
}

@Composable
fun AlertDialog2(openDialog: MutableState<Boolean>) {
    if (openDialog.value) {
        AlertDialog(
            shape = RoundedCornerShape(6.dp),
            onDismissRequest = {
                // 当用户点击对话框以外的地方或者按下系统返回键将会执行的代码
                openDialog.value = false
            },
            title = {
                Text(
                    text = "开启位置服务",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center)

                )
            },
            text = {
                Text(
                    text = "这将意味着，我们会给您提供精准的位置服务，并且您将接受关于您订阅的位置信息",
                    fontSize = 14.sp
                )

            },
            confirmButton = {
                TextButton(
                    onClick = { openDialog.value = false },
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                    shape = RoundedCornerShape(4.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 0.dp)
                ) {
                    Text(
                        text = "取消",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W700,
                    )

                }

                TextButton(
                    onClick = { openDialog.value = false },
                    colors = ButtonDefaults.buttonColors(
                        MaterialTheme.colorScheme.primary
                    ),
                    shape = RoundedCornerShape(4.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 0.dp)
                ) {

                    Text(
                        text = "确认",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W700,
                        color = MaterialTheme.colorScheme.onPrimary
                    )

                }
            }
//            dismissButton = {
//                TextButton(
//                    onClick = { openDialog.value = false },
//                    shape = RoundedCornerShape(4.dp)
//                ) {
//                    Text(
//                        text = "取消",
//                        fontSize = 14.sp,
//                        fontWeight = FontWeight.W700,
//
//                        )
//
//                }
//            }

        )
    }
}