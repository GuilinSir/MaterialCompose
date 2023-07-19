package com.guilin.mycompose.ui.view.components.sliders

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
 * @date :   2023/7/19 8:38 AM
 */
@Composable
fun NavController.RangeSliderPage() {
    var sliderPosition by remember { mutableStateOf(0f..100f) }
    var sliderPosition2 by remember { mutableStateOf(0f..100f) }

    Scaffold(topBar = {
        TopBarView(true, "RangeSlider", this@RangeSliderPage, true)
    }, content = {
        Column(
            Modifier
                .padding(it)
                .padding(horizontal = 20.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = sliderPosition.toString())
            RangeSlider(
                modifier = Modifier.semantics { contentDescription = "Localized Description" },
                value = sliderPosition,
                onValueChange = { range -> sliderPosition = range },
                valueRange = 0f..100f,
                onValueChangeFinished = {
                    // launch some business logic update with the state you hold
                    // viewModel.updateSelectedSliderValue(sliderPosition)
                },
            )
            Spacer(Modifier.height(10.dp))
            Text(text = sliderPosition2.toString())
            RangeSlider(
                modifier = Modifier.semantics { contentDescription = "Localized Description" },
                steps = 9,
                value = sliderPosition2,
                onValueChange = { range -> sliderPosition2 = range },
                valueRange = 0f..100f,
                onValueChangeFinished = {
                    // launch some business logic update with the state you hold
                    // viewModel.updateSelectedSliderValue(sliderPosition)
                },
            )
        }

    })
}