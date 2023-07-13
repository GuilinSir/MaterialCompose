package com.guilin.mycompose.bean

import androidx.compose.ui.graphics.Color

/**
 * @description:
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/7/4 3:35 PM
 */
data class ThemeBean(
    var state: Int,
    var name: String,
    var primary: Color,
    var secondary: Color,
    var tertiary:Color
)