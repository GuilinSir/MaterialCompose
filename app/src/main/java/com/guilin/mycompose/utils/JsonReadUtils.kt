package com.guilin.mycompose.utils

import android.content.Context
import androidx.navigation.NavController
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.io.UnsupportedEncodingException

/**
 * @description:
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/7/12 4:54 PM
 */
class JsonReadUtils private constructor() {

    private object StreamUtilsInstance {
        val jsonReadUtils = JsonReadUtils()
    }

    companion object {
        fun getInstance(): JsonReadUtils {
            return StreamUtilsInstance.jsonReadUtils
        }
    }

    fun get(context: Context, id: Int): String {
        val stream = context.resources.openRawResource(id)
        return read(stream)
    }

    fun read(stream: InputStream): String {
        return read(stream, "utf-8")
    }

    fun read(inputStream: InputStream, encode: String): String {
        if (inputStream != null) {
            try {
                val reader = BufferedReader(InputStreamReader(inputStream, encode))
                var line = reader.readLine()
                var result = ""
                while (line != null) {
                    result += line
                    line = reader.readLine()
                }
                inputStream.close()
                return result
            } catch (e: UnsupportedEncodingException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }
        return ""
    }

}
