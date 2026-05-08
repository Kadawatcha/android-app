package com.example.kad.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    // 1. Les données (L'état)
    var number by mutableIntStateOf(0)
    var showerror by mutableStateOf(false)

    // 2. Les actions (La logique)
    fun increment(value: Int) {
        number += value
        showerror = false
    }

    fun decrement(value: Int) {
        if (number >= value) {
            number -= value
            showerror = false
        } else {
            // Si on essaie de descendre trop bas, on bloque à 0
            number = 0
            showerror = true
        }
    }

    fun reset() {
        number = 0
        showerror = false
    }
}