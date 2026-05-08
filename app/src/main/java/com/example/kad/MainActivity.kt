package com.example.kad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.kad.ui.CounterScreen // Import de ton nouvel écran
import com.example.kad.viewmodel.CounterViewModel // Import du cerveau
import com.example.kad.ui.theme.KadTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // On prépare le cerveau
        val viewModel = CounterViewModel()

        setContent {
            KadTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // On appelle l'artiste (l'écran) et on lui donne les outils
                    CounterScreen(viewModel = viewModel, padding = innerPadding)
                }
            }
        }
    }
}