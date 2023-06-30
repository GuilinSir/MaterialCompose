package com.guilin.mycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.guilin.mycompose.ui.theme.MyComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
