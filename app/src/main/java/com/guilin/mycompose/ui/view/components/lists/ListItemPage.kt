package com.guilin.mycompose.ui.view.components.lists

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.guilin.mycompose.R
import com.guilin.mycompose.ui.wight.TopBarView

/**
 * @description:
 * @author:  guilin
 * @email:   308139995@qq.com
 * @date :  2023/7/14 9:42 AM
 *
 */
@Composable
fun NavController.ListItemPage() {
    Scaffold(
        topBar = {
            TopBarView(
                true,
                "ListItem",
                this@ListItemPage,
                true
            )
        },
        content = {
            Column(
                Modifier
                    .padding(it)
                    .fillMaxSize(),
                // verticalArrangement = Arrangement.Center,
                // horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                ListItem(
                    headlineContent = { Text("One line list item with image") },
                    leadingContent = {
                        Image(
                            painter = painterResource(id = R.drawable.img_avatar),
                            contentDescription = "111",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .width(160.dp)
                                .height(80.dp)
                        )

//                        Icon(
//                            Icons.Filled.Favorite,
//                            contentDescription = "Localized description",
//                        )
                    }
                )
                Divider()
                ListItem(
                    headlineContent = { Text("Two line list item with trailing") },
                    supportingContent = { Text("Secondary text") },
                    trailingContent = { Text("meta") },
                    leadingContent = {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = "Localized description",
                        )
                    }
                )
                Divider()
                ListItem(
                    headlineContent = { Text("Three line list item") },
                    overlineContent = { Text("OVERLINE") },
                    supportingContent = { Text("Secondary text") },
                    leadingContent = {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = "Localized description",
                        )
                    },
                    trailingContent = { Text("meta") }
                )
                Divider()
                ListItem(
                    headlineContent = { Text("Four line list item") },
                    supportingContent = {
                        Text("Secondary text that is long and perhaps goes onto another line")
                    },
                    leadingContent = {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = "Localized description",
                        )
                    },
                    trailingContent = { Text("meta") }
                )
                Divider()
            }
        }
    )

}


