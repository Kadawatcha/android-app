package com.example.kad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import com.example.kad.ui.theme.KadTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KadTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column (
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding) // On applique la marge du Scaffold ici UNE SEULE FOIS
                            ) {
                        Calculette()

                    }


                }
            }
        }
    }
}


@Composable
fun Calculette(modifier : Modifier = Modifier) {
    val touches = listOf("7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "C", "0", "=", "+")
    var affichage by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        // 1. L'ÉCRAN (Le "pousseur")
        Text(
            text = affichage,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f) // C'EST LUI LE SECRET !
                .padding(24.dp)
        )

        // 2. LES BOUTONS
        // Ils vont être poussés tout en bas parce que le Text au-dessus
        // a pris tout l'espace libre avec son weight(1f).
        touches.chunked(4).forEach { ligne ->
            Row(modifier = Modifier.fillMaxWidth()) {
                ligne.forEach { touche ->
                    Button(
                        onClick = {
                            when (touche) {
                                "C" -> affichage = ""
                                "=" -> { /* TODO: Implement calculation logic */
                                }

                                else -> affichage += touche
                            }
                        },
                        modifier = Modifier.weight(1f).padding(4.dp)
                    ) {
                        Text(touche)
                    }
                }
            }
        }
    }
}