package com.guilin.mycompose.ui.view.components.navigation_drawer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.DismissibleDrawerSheet
import androidx.compose.material3.DismissibleNavigationDrawer
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.guilin.mycompose.ui.wight.TopBarView
import kotlinx.coroutines.launch

/**
 * @description:DismissibleNavigationDrawer
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/7/12 14:11
 */
@Composable
fun NavController.DismissibleNavigationDrawerPage() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val items = listOf(Icons.Default.Favorite, Icons.Default.Face, Icons.Default.Email)
    val selectItem = remember {
        mutableStateOf(items[0])
    }

    Scaffold(topBar = {
        TopBarView(true, "DismissibleNavigationDrawer", this@DismissibleNavigationDrawerPage, true)
    }, content = {
        Column(
            Modifier
                .padding(it)
        ) {
            DismissibleNavigationDrawer(
                drawerState = drawerState,
                drawerContent = {
                    DismissibleDrawerSheet(
                        //drawerContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                        //drawerContentColor =MaterialTheme.colorScheme.onSecondaryContainer
                    ) {
                        Spacer(Modifier.height(12.dp))
                        items.forEach() {
                            NavigationDrawerItem(
                                colors = NavigationDrawerItemDefaults.colors(
                                    selectedContainerColor = MaterialTheme.colorScheme.primary,
                                    //unselectedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                                    selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                                    selectedIconColor = MaterialTheme.colorScheme.onPrimary
                                ),
                                label = { Text(it.name) },
                                selected = it == selectItem.value,
                                icon = {
                                    Icon(it, null)
                                },
                                onClick = {
                                    scope.launch { drawerState.close() }
                                    selectItem.value = it
                                },
                                modifier = Modifier.padding(horizontal = 12.dp)
                            )
                        }
                    }

                },
                content = {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = if (drawerState.isClosed) ">>> Swipe >>>" else "<<< Swipe <<<")
                        Spacer(Modifier.height(20.dp))
                        Button(onClick = { scope.launch { drawerState.open() } }) {
                            Text("Click to open")
                        }
                    }
                }
            )
        }
    })
}