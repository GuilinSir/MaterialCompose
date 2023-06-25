package com.guilin.mycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.guilin.mycompose.ui.theme.MyComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun Greetings(modifier: Modifier = Modifier) {
    val names: List<String> = List(1000) { "$it" }
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
            Greeting(name)
        }

    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    //如需在重组后保留状态，请使用remember记住可变状态
    val isExpanded = remember {
        mutableStateOf(false)

    }
    //animateDpAsState动画，animationSpec可以自定义动画
    val extraPadding by animateDpAsState(if (isExpanded.value) 48.dp else 0.dp)
    
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding.coerceAtLeast(0.dp))
            ) {
                Text(text = "Hello,")
                Text(text = name)
            }
            ElevatedButton(
                //Button具有一个名为onClick的形参，但它不接受值，而接受函数
                onClick = {
                    isExpanded.value = !isExpanded.value
                },
            ) {
                Text(
                    if (isExpanded.value) {
                        "Show less"
                    } else {
                        "Show more"
                    }
                )
            }
        }
    }

}


@Composable
fun OnboardingScreen(onContinueClicked: () -> Unit, modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Basics Codelab!")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("Continue")
        }
    }
}

@Composable
private fun MyApp(modifier: Modifier = Modifier) {
    ////可以使用rememberSaveable，而不使用remeber。这会保存每个在配置更改（如旋转）和进程终止后保留下来的状态。
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }
    Surface(modifier) {
        if (shouldShowOnboarding) {
            OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
        } else {
            Greetings()
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingPreview() {
    MyComposeTheme {
        Greetings()
    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    MyComposeTheme {
        MyApp(Modifier.fillMaxSize())
    }
}