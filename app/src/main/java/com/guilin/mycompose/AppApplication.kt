package com.guilin.mycompose

import android.app.Application
import com.guilin.mycompose.utils.SpUtils

/**
 * @description:
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/7/4 1:44 PM
 */
open class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        SpUtils.initMMKV(this)
    }
}