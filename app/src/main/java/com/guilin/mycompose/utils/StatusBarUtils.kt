package com.guilin.mycompose.utils

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

/**
 * @description:
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/7/3 11:06 AM
 */
@SuppressLint("DiscouragedApi", "InternalInsetResource")
@Composable
fun getStatusBarHeight(): Int {
    with(LocalContext.current) {
        val statusBarHeight = resources.getDimensionPixelSize(
            resources.getIdentifier(
                "status_bar_height",
                "dimen",
                "android"
            )
        )
        return statusBarHeight
    }

}

@Composable
fun getStatusBarHeightDp(): Dp {

    with(LocalDensity.current) {
        val statusBarHeightDp = getStatusBarHeight().toDp()
        return statusBarHeightDp
    }


}
