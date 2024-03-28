package com.kivous.composeui.recipes_app_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.kivous.composeui.recipes_app_ui.data.strawberryCake
import com.kivous.composeui.recipes_app_ui.screens.HomeScreen
import com.kivous.composeui.recipes_app_ui.ui.theme.ComposeUITheme

class RecipeUIActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeUITheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen(strawberryCake)
                }
            }
        }
    }
}
