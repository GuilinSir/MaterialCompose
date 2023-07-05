package com.guilin.mycompose.utils

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * @description:
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/7/5 9:08 AM
 */
class MMKVDelegate<T>(private val key: String, private val def: T) : ReadWriteProperty<Any?, T> {

    override fun getValue(thisRef: Any?, property: KProperty<*>): T = MMKVUtils.decode(key, def)

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) =
        MMKVUtils.encode(key, value)
}
