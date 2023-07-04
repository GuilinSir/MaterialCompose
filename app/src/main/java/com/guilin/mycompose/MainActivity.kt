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
import com.guilin.mycompose.constant.NavHost
import com.guilin.mycompose.ui.theme.MyComposeTheme
import com.guilin.mycompose.ui.theme.getThemeColor

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        /**
         * 主题状态
         */
        setContent {
            MyComposeTheme(colors = getThemeColor()) {
                Surface(color = MaterialTheme.colorScheme.background) {
                    NavHost().MainNavigation()
                }
            }
        }

    }


}


/**
 * 获取当前默认主题
 */


@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    MyComposeTheme(getThemeColor()) {
        NavHost().MainNavigation()
    }
}

