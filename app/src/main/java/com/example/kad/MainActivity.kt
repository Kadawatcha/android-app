package com.example.kad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kad.ui.CounterScreen
import com.example.kad.ui.theme.KadTheme
import com.example.kad.viewmodel.CounterViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            // Utilisation de la fonction viewModel() pour récupérer l'instance du ViewModel
            val myViewModel: CounterViewModel = viewModel()

            KadTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // On passe le viewModel et les marges du Scaffold à ton écran
                    CounterScreen(
                        viewModel = myViewModel,
                        padding = innerPadding
                    )
                }
            }
        }
    }
}