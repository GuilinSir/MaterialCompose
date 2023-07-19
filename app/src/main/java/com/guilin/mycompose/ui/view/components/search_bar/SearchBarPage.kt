package com.guilin.mycompose.ui.view.components.search_bar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.isContainer
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.guilin.mycompose.ui.wight.TopBarView

/**
 * @description:圆形进度条
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :   2023/7/18 10:20 AM
 *@ExperimentalMaterial3Api
 * @Composable
 * fun SearchBar(
 *     query: String,要在搜索栏的输入字段中显示的查询文本
 *     onQueryChange: (String) -> Unit,当输入服务更新查询时要调用的回调。更新的文本作为回调的参数。
 *     onSearch: (String) -> Unit,当输入服务触发操作时要调用的回调ImeAction.Search。电流query作为回调的参数。
 *     active: Boolean,该搜索栏是否处于活动状态
 *     onActiveChange: (Boolean) -> Unit,当此搜索栏的活动状态更改时要调用的回调
 *     modifier: Modifier = Modifier,控制此搜索栏的启用状态。当 时false，该组件将不会响应用户输入，并且它将显示为视觉禁用且对辅助功能服务禁用。
 *     enabled: Boolean = true,控制此搜索栏的启用状态。当 时false，该组件将不会响应用户输入，并且它将显示为视觉禁用且对辅助功能服务禁用。
 *     placeholder: (@Composable () -> Unit)? = null,搜索栏为query空时显示的占位符。
 *     leadingIcon: (@Composable () -> Unit)? = null,显示在搜索栏容器开头的前导图标
 *     trailingIcon: (@Composable () -> Unit)? = null,显示在搜索栏容器末尾的尾随图标
 *     shape: Shape = SearchBarDefaults.inputFieldShape,
 *     colors: SearchBarColors = SearchBarDefaults.colors(),
 *     tonalElevation: Dp = SearchBarDefaults.TonalElevation,
 *     shadowElevation: Dp = SearchBarDefaults.ShadowElevation,
 *     windowInsets: WindowInsets = SearchBarDefaults.windowInsets,
 *     interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
 *     content: @Composable ColumnScope.() -> Unit该搜索栏的内容将显示在输入字段下方
 * ): Unit
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavController.SearchBarPage() {

    var text by rememberSaveable { mutableStateOf("") }
    var active by rememberSaveable { mutableStateOf(false) }

    Scaffold(topBar = {
        TopBarView(true, "SearchBar", this@SearchBarPage, true)
    }, content = {
        Column(
            Modifier
                .padding(it)
                .fillMaxSize(),
            //verticalArrangement = Arrangement.Center,
            //horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .semantics{
                        @Suppress("DEPRECATION")
                        isContainer = true
                    }
                    .zIndex(1f)
                    .fillMaxWidth()
            ) {
                SearchBar(
                    modifier = Modifier.align(Alignment.TopCenter),
                    query = text,
                    onQueryChange = { text = it },
                    onSearch = { active = false },
                    active = active,
                    onActiveChange = {
                        active = it
                    },
                    placeholder = { Text("Hinted search text") },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                    trailingIcon = { Icon(Icons.Default.MoreVert, contentDescription = null) }
                ) {
                    LazyColumn(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        items(4) { idx ->
                            val resultText = "Suggestion $idx"
                            ListItem(
                                headlineContent = { Text(resultText) },
                                supportingContent = { Text("Additional info") },
                                leadingContent = { Icon(Icons.Filled.Star, contentDescription = null) },
                                modifier = Modifier.clickable {
                                    text = resultText
                                    active = false
                                }
                            )
                        }
                    }
                }
            }
            LazyColumn(
                contentPadding = PaddingValues(start = 16.dp, top = 10.dp, end = 16.dp, bottom = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                val list = List(100) { "Text $it" }
                items(count = list.size) {
                    Text(list[it], Modifier.fillMaxWidth().padding(horizontal = 16.dp))
                }
            }

        }

    })
}