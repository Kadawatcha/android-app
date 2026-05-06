package com.example.kad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.kad.ui.theme.KadTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KadTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TestDeuxBtns(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


/*@Composable
fun MaPageDeTests(modifier: Modifier = Modifier) {
    // 1. Les variables d'état (State)
    var estClique by remember { mutableStateOf(false) }
    val context = LocalContext.current // Indispensable pour le Toast

    // 2. La colonne parente qui organise tout l'écran
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center, // Centre le bloc verticalement
        horizontalAlignment = Alignment.CenterHorizontally // Centre horizontalement
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        // --- SECOND BLOC : BOUTON NOTIFICATION ---
        Button(
            onClick = {
                // Création de la petite notification (Toast)
                Toast.makeText(
                    context,
                    "Coucou ! C'est la notif de Kad",
                    Toast.LENGTH_LONG
                ).show()
            },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(90.dp)
        ) {
            Text("Lancer la notif")

        }
    }
}*/

@Composable
fun TestDeuxBtns(modifier: Modifier = Modifier){
    var click by remember { mutableStateOf(value=false) }
    var click2 by remember { mutableStateOf(false) }

    Row(
        modifier = modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Text("Colonne de gauche")
            Button(onClick = { click = !click }) {
                Text(if (click) "Activé" else "Désactivé")
            }
        }
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Text("Colonne de droite")
            Button(
                onClick = { click2 = !click2 },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (click2) Color.Cyan else Color.Blue
                )
            ) {
                Text(if (click2) "On" else "Off")
            }
        }
    }
}