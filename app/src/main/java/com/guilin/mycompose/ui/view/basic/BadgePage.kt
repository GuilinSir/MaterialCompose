package com.guilin.mycompose.ui.view.basic

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.guilin.mycompose.ui.wight.TopBarView

/**
 * @description:
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/7/10 3:22 PM
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavController.BadgePage() {
    Column(Modifier.fillMaxSize()) {
        TopBarView(true, "Alertdialog", this@BadgePage, true)
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Badge(content = {
                Text(text = "")
            })
            Spacer(modifier = Modifier.size(5.dp))
            Badge(content = {
                Text(text = "1")
            })
            Spacer(modifier = Modifier.size(5.dp))
            Badge(content = {
                Text(text = "10")
            })
            Spacer(modifier = Modifier.size(5.dp))
            Badge(content = {
                Text(text = "100")
            })
            Spacer(modifier = Modifier.size(5.dp))
            NavigationBar {
                NavigationBarItem(
                    icon = {
                        BadgedBox(
                            badge = {
                                Badge {
                                    val badgeNumber = "8"
                                    Text(
                                        badgeNumber,
                                        modifier = Modifier.semantics {
                                            contentDescription = "$badgeNumber new notifications"
                                        }
                                    )
                                }
                            }) {
                            Icon(
                                Icons.Filled.Star,
                                contentDescription = "Favorite"
                            )
                        }
                    },
                    selected = false,
                    onClick = {}
                )
            }
        }
    }
}