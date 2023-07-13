package com.guilin.mycompose.ui.view.components.checkbox

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.guilin.mycompose.ui.wight.TopBarView

/**
 * @description:
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/7/10 2:42 PM
 */
@SuppressLint("MutableCollectionMutableState")
@Composable
fun NavController.CheckboxPage() {
    var checkedState0 by remember {
        mutableStateOf(false)
    }
    var (checkedState, onStateChange) = remember { mutableStateOf(true) }

    Scaffold(topBar = {
        TopBarView(true, "Checkbox", this@CheckboxPage, true)
    }) {
        Column(
            Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Checkbox(checked = checkedState0, onCheckedChange = {
                checkedState0 = it
            })

            Row(
                Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .toggleable(
                        value = checkedState,
                        onValueChange = {
                            onStateChange(!checkedState)
                        },
                        role = Role.Checkbox
                    )
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = checkedState,
                    onCheckedChange = null // null recommended for accessibility with screenreaders
//                    {
//                        onStateChange(it)
//                        Log.e("123",checkedState.toString())
//                    }
                )
                Text(
                    text = "Option selection",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}