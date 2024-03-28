package com.kivous.composeui.recipes_app_ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.kivous.composeui.recipes_app_ui.data.Recipe


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen(recipe: Recipe) {
    Box {
        Content(recipe)
    }
}

@Composable
fun ParallaxToolbar(recipe: Recipe) {

}

@Composable
fun Content(recipe: Recipe) {

}