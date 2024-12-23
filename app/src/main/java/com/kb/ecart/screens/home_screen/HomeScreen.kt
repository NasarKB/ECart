package com.kb.ecart.screens.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kb.ecart.R
import com.kb.ecart.components.ScreenHolder
import com.kb.ecart.items.CartListItem
import com.kb.ecart.network.model.ProductItemModel
import com.kb.ecart.ui.theme.ECartTheme
import com.kb.ecart.ui.theme.colorPrimaryText
import com.kb.ecart.ui.theme.colorSearchBg
import com.kb.ecart.ui.theme.colorWhite

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun HomeScreen() {
    ScreenHolder(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Toggle Switch
                Icon(
                    painter = painterResource(id = R.drawable.ic_toogle),
                    contentDescription = "toogle Icon",
                    modifier = Modifier
                        .width(38.dp)
                        .height(22.dp)
                )

                // Basket Icon with Text
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .clickable {

                        },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_basket), // Replace with your basket icon resource
                        contentDescription = "Basket Icon",
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "My basket",
                        style = MaterialTheme.typography.bodyMedium,
                        color = colorPrimaryText
                    )
                }
            }
        },
        content = {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(colorWhite)
                .padding(16.dp)) {
                Text(
                    text = buildAnnotatedString {
                        append("Hello Tony, ")
                        addStyle(
                            style = SpanStyle(fontWeight = FontWeight(400)),
                            start = 0,
                            end = 11 // "Hello Tony," length
                        )
                        // Bold text: "What fruit salad combo do you want today?"
                        append("What fruit salad \ncombo do you want today?")
                        addStyle(
                            style = SpanStyle(fontWeight = FontWeight(600)),
                            start = 12, // Start of bold text
                            end = 54 // Total length
                        )
                    },
                    fontSize = 20.sp,
                    color = colorPrimaryText
//                    style = TextStyle(
//                        fontSize = 20.sp,
//                        fontFamily = FontFamily(Font(R.font.brandon_grotesque)),
//                        color = colorPrimaryText,)
                )
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = colorSearchBg)
                    .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search), // Replace with your basket icon resource
                        contentDescription = "Search Icon",
                        modifier = Modifier.size(18.dp))

                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .height(50.dp)
                            .padding(end = 8.dp, bottom = 0.dp, top = 0.dp),
                        value = "",
                        singleLine = true,
                        enabled = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text
                        ),
                        textStyle = TextStyle(fontSize = 14.sp),
                        placeholder = {
                            Text(
                                text = stringResource(id = R.string.search_for_fruit_salad_combos),
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                fontSize = 14.sp
                            )
                        },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            cursorColor = Color.Black,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                        ),
                        onValueChange = {

                        }) }

                Text(
                    modifier = Modifier.padding(top = 16.dp, bottom = 10.dp),
                    text = stringResource(id = R.string.recommended_combo),
                    style = TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 32.sp,
                        fontFamily = FontFamily(Font(R.font.brandon_grotesque)),
                        fontWeight = FontWeight(500),
                        color = colorPrimaryText,)
                )
                FlowRow(
                    modifier = Modifier
                        .padding(16.dp),
                    maxItemsInEachRow = 2) {
                    repeat(10) {
                        CartListItem(model = ProductItemModel(1,"Product 1",200,""))
                    }
//                    productList.forEach { item ->
//                        BasicText(
//                            text = item,
//                            modifier = Modifier
//                                .background(Color.LightGray)
//                                .padding(8.dp),
//                            textAlign = TextAlign.Center
//                        )
//                    }
                }
            }

        })
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ECartTheme {
        HomeScreen()
    }
}