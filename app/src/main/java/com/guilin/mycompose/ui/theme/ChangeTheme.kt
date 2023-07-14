package com.guilin.mycompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import com.guilin.common.constant.SpKey
import com.guilin.mycompose.enum.ThemeEnum
import com.guilin.mycompose.ui.theme.color.DarkColorsGreen
import com.guilin.mycompose.ui.theme.color.DarkColorsOrange
import com.guilin.mycompose.ui.theme.color.DarkColorsPurple
import com.guilin.mycompose.ui.theme.color.DarkColorsRed
import com.guilin.mycompose.ui.theme.color.LightColorsGreen
import com.guilin.mycompose.ui.theme.color.LightColorsOrange
import com.guilin.mycompose.ui.theme.color.LightColorsPurple
import com.guilin.mycompose.ui.theme.color.LightColorsRed
import com.guilin.mycompose.utils.MMKVDelegate
import com.guilin.mycompose.utils.MMKVUtils

/**
 * @description:
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/7/4 3:19 PM
 */
var state by MMKVDelegate(SpKey.CHANGED_THEME,0)
val themeTypeState: Lazy<MutableState<Int>> =
    lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        mutableIntStateOf(state)
    }

@Composable
fun getThemeColor(): ColorScheme {

    return when (themeTypeState.value.value) {
        ThemeEnum.PURPLE_THEME.state -> if (!isSystemInDarkTheme()) LightColorsPurple else DarkColorsPurple
        ThemeEnum.GREEN_THEME.state -> if (!isSystemInDarkTheme()) LightColorsGreen else DarkColorsGreen
        ThemeEnum.RED_THEME.state -> if (!isSystemInDarkTheme()) LightColorsRed else DarkColorsRed
        ThemeEnum.ORANGE_THEME.state -> if (!isSystemInDarkTheme()) LightColorsOrange else DarkColorsOrange

        else -> {
            if (!isSystemInDarkTheme()) LightColorsPurple else DarkColorsPurple
        }
    }
}
