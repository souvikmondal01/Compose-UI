package com.kivous.composeui.onboarding_screen_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.kivous.composeui.R
import com.kivous.composeui.onboarding_screen_ui.ui.theme.ColorBlue
import com.kivous.composeui.onboarding_screen_ui.ui.theme.ColorGreen
import com.kivous.composeui.onboarding_screen_ui.ui.theme.ColorYellow
import com.kivous.composeui.onboarding_screen_ui.ui.theme.ComposeUITheme

class OnboardingActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            ComposeUITheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val items = listOf(
                        OnboardData(
                            R.drawable.fruit, ColorBlue, ColorBlue, "Hmmm, Healthy Food",
                            "A variety of healthy foods made by the best chefs. Ingredients are easy to find. all delicious flavors can only be found at cookbunda",
                        ),
                        OnboardData(
                            R.drawable.cooking, ColorGreen, ColorGreen, "Fresh Drinks, Stay Fresh",
                            "Not only food. we provide clear healthy drink options for you. Fresh taste always accompanies you",
                        ),
                        OnboardData(
                            R.drawable.food, ColorYellow, ColorYellow, "Let’s Cooking",
                            "Are you ready to make a dish for your friends or family? create an account and cook",
                        ),
                    )

//                    val pagerState = rememberPagerState(
//                        pageCount = items.size,
//                        initialOffscreenLimit = 2,
//                        infiniteLoop = false,
//                        initialPage = 0
//                    )

                    val pagerState = rememberPagerState()

                    OnboardPager(
                        item = items,
                        pagerState = pagerState,
                        modifier = Modifier.fillMaxSize()
                    )

                }
            }
        }
    }


}

@ExperimentalPagerApi
@Composable
fun OnboardPager(
    item: List<OnboardData>,
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {

    Box(modifier = modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HorizontalPager(count = item.size, state = pagerState) { page ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(item[page].background),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    Image(painter = painterResource(id = item[page].image), contentDescription = "")
                }
            }

        }

        Box(
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Card(
                colors = CardDefaults.cardColors(Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(340.dp),
                elevation = CardDefaults.cardElevation(0.dp),
                shape = RoundedCornerShape(topStart = 80.dp)
            ) {
                Box(
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        PagerIndicator(
                            items = item,
                            currentPage = pagerState.currentPage
                        )
                        Text(text = item[pagerState.currentPage].title)
                    }
                }

            }
        }

    }

}

@Composable
fun PagerIndicator(
    items: List<OnboardData>, currentPage: Int
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(top = 20.dp)
    ) {
        repeat(items.size) {
            Indicator(
                isSelected = it == currentPage,
                color = items[it].mainColor
            )
        }
    }

}

@Composable
fun Indicator(
    isSelected: Boolean,
    color: Color
) {
    val width = animateDpAsState(targetValue = if (isSelected) 40.dp else 10.dp, label = "")
    Box(
        modifier = Modifier
            .padding(4.dp)
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelected) color else Color.Gray.copy(.5f)
            )

    ) {

    }
}
