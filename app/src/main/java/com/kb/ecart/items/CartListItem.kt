package com.kb.ecart.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kb.ecart.R
import com.kb.ecart.network.model.ProductItemModel
import com.kb.ecart.ui.theme.colorHighlightText
import com.kb.ecart.ui.theme.colorPrimaryText
import com.kb.ecart.ui.theme.colorWhite

@Composable
fun CartListItem(model: ProductItemModel){
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    Column(
        modifier = Modifier
            .padding(12.dp)
            .width(screenWidth * 0.35f)
            .shadow(elevation = 60.dp, spotColor = Color(0x0D202020), ambientColor = Color(0x0D202020))
            .background(color = colorWhite, shape = RoundedCornerShape(size = 16.dp)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.width(80.dp),
            painter = painterResource(id = R.drawable.ic_toogle), contentDescription ="img product" )

        Text(
            modifier = Modifier.padding(vertical = 10.dp),
            text = model.name,
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.brandon_grotesque)),
                fontWeight = FontWeight(500),
                color = colorPrimaryText,))

        Row {
            Icon(
                modifier = Modifier.size(18.dp),
                painter = painterResource(id = R.drawable.ic_currency), contentDescription ="img currency" )
            Text(
                modifier = Modifier.weight(1f),
                text = model.price.toString(),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.brandon_grotesque)),
                    fontWeight = FontWeight(400),
                    color = colorHighlightText,))
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.ic_add_item), contentDescription ="img add" )
        }
    }
}