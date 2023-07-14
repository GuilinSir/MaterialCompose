package com.guilin.mycompose.ui.view.components.dividers

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
import androidx.compose.material3.Divider
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.guilin.mycompose.ui.wight.TopBarView

/**
 * @description:
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :    2023/7/14 8:32 AM
 *
 */
@Composable
fun NavController.DividerPage() {

    Scaffold(topBar = {
        TopBarView(true, "Divider", this@DividerPage, true)
    }, content = {
        Column(
            Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Divider(
                modifier = Modifier.padding(horizontal = 40.dp),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.primary
            )
            Divider(
                modifier = Modifier.padding(start = 40.dp, top = 10.dp, bottom = 0.dp, end = 40.dp),
                thickness = 2.dp,
                color = MaterialTheme.colorScheme.primary
            )
            Divider(
                modifier = Modifier.padding(start = 40.dp, top = 10.dp, bottom = 0.dp, end = 40.dp),
                thickness = 3.dp,
                color = MaterialTheme.colorScheme.primary
            )
            Divider(
                modifier = Modifier.padding(start = 40.dp, top = 10.dp, bottom = 0.dp, end = 40.dp),
                thickness = 4.dp,
                color = MaterialTheme.colorScheme.primary
            )
            Divider(
                modifier = Modifier.padding(start = 40.dp, top = 10.dp, bottom = 0.dp, end = 40.dp),
                thickness = 5.dp,
                color = MaterialTheme.colorScheme.primary
            )
            Divider(
                modifier = Modifier.padding(start = 40.dp, top = 10.dp, bottom = 0.dp, end = 40.dp),
                thickness = 7.dp,
                color = MaterialTheme.colorScheme.primary
            )
            Divider(
                modifier = Modifier.padding(start = 40.dp, top = 10.dp, bottom = 0.dp, end = 40.dp),
                thickness = 10.dp,
                color = MaterialTheme.colorScheme.primary
            )
        }
    })

}


