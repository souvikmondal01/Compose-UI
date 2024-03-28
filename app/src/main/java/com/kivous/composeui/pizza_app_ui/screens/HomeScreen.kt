package com.kivous.composeui.pizza_app_ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kivous.composeui.R
import com.kivous.composeui.pizza_app_ui.common.AppIconButton
import com.kivous.composeui.pizza_app_ui.common.SpacerHeight
import com.kivous.composeui.pizza_app_ui.common.SpacerWidth
import com.kivous.composeui.pizza_app_ui.data.Pizza
import com.kivous.composeui.pizza_app_ui.data.pizzaList
import com.kivous.composeui.pizza_app_ui.ui.theme.BackgroundColor
import com.kivous.composeui.pizza_app_ui.ui.theme.DarkBlackColor
import com.kivous.composeui.pizza_app_ui.ui.theme.LightGrayColor
import com.kivous.composeui.pizza_app_ui.ui.theme.RedColor
import com.kivous.composeui.pizza_app_ui.ui.theme.YellowColor


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen() {
    val menuList =
        listOf("Starter", "Asian", "Placha & Roast & Grill", "Classic", "Indian", "Italian")
    var currentMenuState by remember {
        mutableStateOf("Starter")
    }
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ) {
        Column {
            HeaderSection()

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(Color.White),
                shape = RoundedCornerShape(0.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(scrollState)
                ) {
                    menuList.forEach {
                        ChipSection(title = it, selected = it == currentMenuState) { data ->
                            currentMenuState = data
                        }
                    }
                }

            }

            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(pizzaList) {
                    ItemPizza(pizza = it)
                }
            }
        }

        ExtendedActionButton(
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.BottomEnd)
        )

    }

}

@Composable
fun ExtendedActionButton(
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .height(48.dp)
            .clip(RoundedCornerShape(28.dp))
            .background(DarkBlackColor)
    ) {
        Row {
            SpacerWidth(20.dp)
            Text(
                text = "$60.40",
                fontSize = 14.sp,
                fontWeight = FontWeight.W600,
                color = Color.White,
                modifier = Modifier.align(CenterVertically)
            )

            Icon(
                painter = painterResource(id = R.drawable.pizza),
                contentDescription = "",
                modifier = Modifier
                    .size(46.dp)
                    .padding(2.dp),
                tint = Color.Unspecified
            )
        }
    }
}

@Composable
fun ItemPizza(pizza: Pizza) {
    Card(
        modifier = Modifier
            .width(175.dp)
            .padding(4.dp),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = pizza.image),
                    contentDescription = "",
                    modifier = Modifier.size(108.dp)
                )
                SpacerHeight()
                Text(
                    text = pizza.price,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                    color = RedColor,
                    textAlign = TextAlign.Center
                )
                SpacerHeight()
                Text(
                    text = pizza.name,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W600,
                    color = DarkBlackColor,
                    textAlign = TextAlign.Center
                )
                SpacerHeight()
                Text(
                    text = pizza.description,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.W300,
                    lineHeight = 10.sp,
                    color = LightGrayColor,
                    textAlign = TextAlign.Center
                )
                SpacerHeight()

                Button(
                    onClick = { },
                    modifier = Modifier.width(88.dp),
                    colors = ButtonDefaults.buttonColors(
                        YellowColor
                    )
                ) {
                    Text(
                        text = "Add",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W600,
                        color = Color.White
                    )
                }

            }

        }

    }
}

@Composable
fun HeaderSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(RedColor),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp, vertical = 16.dp
                ), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                AppIconButton(icon = R.drawable.menu) {}
                SpacerWidth(16.dp)
                Text(
                    text = "Pizza App",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W600,
                    color = Color.White
                )
            }

            AppIconButton(icon = R.drawable.search) {}
        }
    }
}

@Composable
fun ChipSection(
    title: String, selected: Boolean, onValueChange: (String) -> Unit
) {

    TextButton(
        onClick = {
            onValueChange(title)
        },
        shape = RoundedCornerShape(200.dp),
        elevation = ButtonDefaults.buttonElevation(0.dp),
        colors = ButtonDefaults.buttonColors(
            if (selected) YellowColor else Color.Transparent
        ),
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
        Text(
            text = title,
            fontSize = 14.sp,
            fontWeight = FontWeight.W600,
            color = if (selected) Color.White else DarkBlackColor
        )
    }

}