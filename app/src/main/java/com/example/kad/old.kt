package com.example.kad

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kad.ui.theme.KadTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KadTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Text(
                        text = "Page de Login",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}



@Composable
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
}

@Composable
fun Buttons(modifier: Modifier = Modifier){
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


@Composable
fun Login(modifier: Modifier = Modifier){
    var texte by remember {mutableStateOf("")}
    var texte2 by remember { mutableStateOf("") }
    var estValide by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(50.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Coucou ma colone ",
            color = Color.Blue,
            fontSize = 30.sp, // Space independent pixel : adapt to user params
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.height(16.dp)) // espacement bas ?

        OutlinedTextField(
            value = texte,
            onValueChange = {
                texte = it
                estValide = false
            }, // it : display le text
            placeholder = {Text(
                text ="Enter password")},

            )
        Button(
            onClick = {
                if (texte == "SALUT"){
                    estValide = true
                }
            }
        ){
            Text("chack password ")
        }

        if (estValide) {
            Spacer(modifier = Modifier.height(4.dp))
            Text("Mot de passe correct !")
        }




        Spacer(modifier = Modifier.height(30.dp))

        TextField(
            value= texte2,
            onValueChange = { texte2 = it },
            placeholder = { Text("Password 2") },
        )

        if (texte2 == "123C") {
            Spacer(modifier = Modifier.height(4.dp))
            Text("Mot de passe correct !")
        }
    }

}