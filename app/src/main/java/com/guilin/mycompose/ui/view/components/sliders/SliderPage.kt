package com.guilin.mycompose.ui.view.components.sliders

import android.annotation.SuppressLint
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SliderState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
@SuppressLint("UnrememberedMutableInteractionSource")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavController.SliderPage() {
    var sliderPosition by remember { mutableStateOf(0f) }
    var sliderPosition2 by remember { mutableStateOf(0f) }
    var sliderPosition3 by remember { mutableStateOf(0f) }

    val sliderState = remember {
        SliderState(
            valueRange = 0f..100f,
            onValueChangeFinished = {
                // launch some business logic update with the state you hold
                // viewModel.updateSelectedSliderValue(sliderPosition)
            }
        )
    }
    val interactionSource = MutableInteractionSource()
    val colors = SliderDefaults.colors(thumbColor = Color.Red, activeTrackColor = Color.Red)

    Scaffold(topBar = {
        TopBarView(true, "Slider", this@SliderPage, true)
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
            Slider(
                modifier = Modifier.semantics { contentDescription = "Localized Description" },
                value = sliderPosition,
                onValueChange = { sliderPosition = it })
            Spacer(Modifier.height(10.dp))
            Text(text = sliderPosition2.toString())
            Slider(
                modifier = Modifier.semantics { contentDescription = "Localized Description" },
                value = sliderPosition2,
                onValueChange = { sliderPosition2 = it },
                valueRange = 0f..100f,
                onValueChangeFinished = {
                    // launch some business logic update with the state you hold
                    // viewModel.updateSelectedSliderValue(sliderPosition)
                },
                steps = 4
            )
            Spacer(Modifier.height(10.dp))
            Text(text = sliderPosition3.toString())
            //自定义滑动按钮
            Slider(
                modifier = Modifier.semantics { contentDescription = "Localized Description" },
                value = sliderPosition3,
                onValueChange = { sliderPosition3 = it },
                valueRange = 0f..5f,
                steps = 9,
                onValueChangeFinished = {
                    // launch some business logic update with the state you hold
                    // viewModel.updateSelectedSliderValue(sliderPosition)
                },
                thumb = {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = null,
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                        tint = Color.Red
                    )
                }
            )

            Spacer(Modifier.height(10.dp))
            Text(text = sliderState.value.toString())
            ////自定义滑动按钮和滑动轨道
            Slider(
                state = sliderState,
                modifier = Modifier.semantics { contentDescription = "Localized Description" },
                interactionSource = interactionSource,
                thumb = {
                    SliderDefaults.Thumb(
                        interactionSource = interactionSource,
                        colors = colors
                    )
                },
                track = {
                    SliderDefaults.Track(
                        colors = colors,
                        sliderState = sliderState
                    )
                }
            )

        }

    })
}