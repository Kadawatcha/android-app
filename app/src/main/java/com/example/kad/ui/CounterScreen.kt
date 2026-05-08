package com.example.kad.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.kad.viewmodel.CounterViewModel

@Composable
fun CounterScreen(
    viewModel: CounterViewModel,
    padding: PaddingValues,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(padding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (viewModel.showerror) {
            Text(
                "le compteur ne peut pas etre inférieur à 0 !",
                color = Color.Red
            )
        }

        Text(
            "Counter = ${viewModel.number}",
            style = MaterialTheme.typography.displaySmall,
            color = when {
                viewModel.number >= 50 -> Color.Red
                viewModel.number >= 10 -> Color.Blue
                else -> MaterialTheme.colorScheme.primary
            },
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(15.dp, Alignment.CenterHorizontally)
        ) {
            OutlinedButton(onClick = { viewModel.decrement(10) }) {
                Text("-10")
            }

            Button(onClick = { viewModel.decrement(1) }) {
                Text("-")
            }

            Button(onClick = { viewModel.increment(1) }) {
                Text("+")
            }

            OutlinedButton(onClick = { viewModel.increment(10) }) {
                Text("+10")
            }
        }

        Spacer(Modifier.height(12.dp))

        OutlinedButton(
            onClick = { viewModel.reset() },
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Text("Reset")
        }
    }
}