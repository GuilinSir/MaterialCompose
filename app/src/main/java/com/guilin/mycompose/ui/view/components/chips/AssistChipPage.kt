package com.guilin.mycompose.ui.view.components.chips

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.guilin.mycompose.R
import com.guilin.mycompose.ui.wight.TopBarView

/**
 * @description:
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/7/10 3:14 PM
 */
@Composable
fun NavController.AssistChipPage() {
    Scaffold(topBar = {
        TopBarView(true, "AssistChip", this@AssistChipPage, true)
    }, content = {
        Column(
            Modifier.padding(it).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AssistChip(
                onClick = { /* Do something! */ },
                label = { Text("Assist Chip") },
                leadingIcon = {
                    Icon(
                        Icons.Filled.Settings,
                        contentDescription = "Localized description",
                        Modifier.size(AssistChipDefaults.IconSize)
                    )
                }
            )
        }
    })
}

