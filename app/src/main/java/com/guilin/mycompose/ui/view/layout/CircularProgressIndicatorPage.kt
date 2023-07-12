package com.guilin.mycompose.ui.view.layout

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.guilin.mycompose.ui.wight.TopBarView
import kotlinx.coroutines.launch

/**
 * @description:BottomSheetScaffold页面
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/7/10 3:22 PM
 *
 *@Composable
 * fun CircularProgressIndicator(
 *     progress: Float,
 *     modifier: Modifier = Modifier,
 *     color: Color = ProgressIndicatorDefaults.circularColor,
 *     strokeWidth: Dp = ProgressIndicatorDefaults.CircularStrokeWidth,
 *     trackColor: Color = ProgressIndicatorDefaults.circularTrackColor,
 *     strokeCap: StrokeCap = ProgressIndicatorDefaults.CircularDeterminateStrokeCap
 * ): Unit
 */
@Composable
fun NavController.CircularProgressIndicatorPage() {
    var progress by remember {
        mutableStateOf(0.1f)
    }
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec, label = ""
    )

    Scaffold(topBar = {
        TopBarView(true, "CircularProgressIndicator", this@CircularProgressIndicatorPage, true)
    }, content = {
        Column(
            Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
            Spacer(Modifier.requiredHeight(30.dp))
            CircularProgressIndicator(progress = animatedProgress)
            Spacer(Modifier.requiredHeight(30.dp))
            OutlinedButton(modifier = Modifier.semantics {
                val progressPercent = (progress * 100).toInt()
                if (progressPercent in 1..100) {
                    stateDescription = "Progress $progressPercent%"
                }
            }, onClick = { if (progress < 1f) progress += 0.1f }) {
                Text(text = "Increase")
            }

            OutlinedButton(modifier = Modifier.semantics {
                val progressPercent = (progress * 100).toInt()
                if (progressPercent in 1..100) {
                    stateDescription = "Progress $progressPercent%"
                }
            }, onClick = { if (progress > 0) progress -= 0.1f }) {
                Text(text = "Reduce")
            }
        }
    })
}