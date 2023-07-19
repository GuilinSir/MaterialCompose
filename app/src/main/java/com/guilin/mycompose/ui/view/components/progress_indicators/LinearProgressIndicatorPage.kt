package com.guilin.mycompose.ui.view.components.progress_indicators

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
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
 * @description:进度条
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/7/18 8:40 AM
 *
 *@Composable
 * fun LinearProgressIndicator(
 *     progress: Float,
 *     modifier: Modifier = Modifier,
 *     color: Color = ProgressIndicatorDefaults.linearColor,
 *     trackColor: Color = ProgressIndicatorDefaults.linearTrackColor,
 *     strokeCap: StrokeCap = ProgressIndicatorDefaults.LinearStrokeCap
 * ): Unit
 */
@Composable
fun NavController.LinearProgressIndicatorPage() {
    var progress by remember { mutableFloatStateOf(0.1f) }
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec, label = ""
    )

    Scaffold(topBar = {
        TopBarView(true, "LinearProgressIndicator", this@LinearProgressIndicatorPage, true)
    }, content = {
        Column(
            Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LinearProgressIndicator(
                modifier = Modifier.semantics(mergeDescendants = true) {}.padding(10.dp)
            )
            Spacer(Modifier.requiredHeight(30.dp))
            LinearProgressIndicator(
                modifier = Modifier.semantics(mergeDescendants = true) {}.padding(10.dp),
                progress = animatedProgress,
            )
            Spacer(Modifier.requiredHeight(30.dp))
            OutlinedButton(
                modifier = Modifier.semantics {
                    val progressPercent = (progress * 100).toInt()
                    if (progressPercent in 0..100) {
                        stateDescription = "Progress $progressPercent%"
                    }
                },
                onClick = {
                    if (progress < 1f) progress += 0.1f
                }
            ) {
                Text("Increase")
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