package com.kivous.composeui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kivous.composeui.ui.theme.ComposeUITheme
import com.kivous.composeui.ui.theme.pizza_app_ui.PizzaAppActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeUITheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier.padding(horizontal = 24.dp)) {

                        AddButton(text = "Pizza App UI") {
                            startActivity(
                                Intent(
                                    this@MainActivity,
                                    PizzaAppActivity::class.java
                                ).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                            )
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun AddButton(text: String, onClick: () -> Unit) {
    Spacer(modifier = Modifier.padding(top = 8.dp))
    Button(
        onClick = {
            onClick()
        }, modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = text)
    }
}

