package com.example.conversoreurodolar.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ConversorViewModel: ViewModel() {

    private val _resultado = MutableLiveData<String>()

    val resultado: LiveData<String>get() = _resultado

    fun euroDolar(euro: Double) {
        val conve = String.format("%.2f", euro * 1.04)
        _resultado.value = ("$conve $")
    }

}