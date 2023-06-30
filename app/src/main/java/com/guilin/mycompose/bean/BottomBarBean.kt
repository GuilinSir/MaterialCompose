package com.guilin.mycompose.bean

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

/**
 * @description:
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/6/30 2:15 PM
 */
data class BottomBarBean(
    @DrawableRes var iconRes: Int,
    //var iconColor: Color,
    var text: String,
    //var textColor: Color
)