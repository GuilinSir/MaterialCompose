package com.guilin.mycompose.utils

import android.content.Context
import com.tencent.mmkv.MMKV

/**
 * @description:MMKV数据存储（使用MMKVDelegate）
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/7/5 9:08 AM
 */
object MMKVUtils {

    fun initMMKV(context: Context): String? = MMKV.initialize(context)

    fun <T> encode(key: String, value: T) {
        when (value) {
            is Int -> MMKV.defaultMMKV()?.encode(key, value)
            is Long -> MMKV.defaultMMKV()?.encode(key, value)
            is Float -> MMKV.defaultMMKV()?.encode(key, value)
            is Double -> MMKV.defaultMMKV()?.encode(key, value)
            is Boolean -> MMKV.defaultMMKV()?.encode(key, value)
            is String -> MMKV.defaultMMKV()?.encode(key, value)
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> decode(key: String, defValue: T): T {
        return when (defValue) {
            is Int -> MMKV.defaultMMKV()?.decodeInt(key, defValue) as T
            is Long -> MMKV.defaultMMKV()?.decodeLong(key, defValue) as T
            is Float -> MMKV.defaultMMKV()?.decodeFloat(key, defValue) as T
            is Double -> MMKV.defaultMMKV()?.decodeDouble(key, defValue) as T
            is Boolean -> MMKV.defaultMMKV()?.decodeBool(key, defValue) as T
            is String -> MMKV.defaultMMKV()?.decodeString(key, defValue) as T
            else -> defValue
        }
    }
}