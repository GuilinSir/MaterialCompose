package com.guilin.mycompose

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.guilin.mycompose.ui.theme.MyComposeTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MyComposeTheme() {
                Surface(color = MaterialTheme.colorScheme.background){
                    NavHost().MainNavigation()
                }

            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    MyComposeTheme (){
        NavHost().MainNavigation()
    }
}
