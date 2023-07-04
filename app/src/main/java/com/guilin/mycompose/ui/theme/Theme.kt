package com.guilin.mycompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable


// Primary通常用于悬浮按钮、按钮、选中状态、hover状态
// OnPrimary是在Primary之上的内容（比如图标、文字）颜色
// PrimaryContainer用于比强调性比Primary弱的元素。
// OnPrimaryContainer是PrimaryContainer上内容的颜色。
// 二级色用于强调程度低于一级色的界面元素。
// 三级色用于平衡一、二级色，通常用于输入控件。


@Composable
fun MyComposeTheme(
    colors:ColorScheme,
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    MaterialTheme(
        colorScheme = colors,
        content = content
    )
}