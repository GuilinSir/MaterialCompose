package com.guilin.mycompose.bean

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

/**
 * @description:
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/7/4 3:35 PM
 */
data class CheckBoxStateBean(
    val state: MutableState<Boolean>
)