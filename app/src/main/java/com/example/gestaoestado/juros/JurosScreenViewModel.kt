package com.example.gestaoestado.juros

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class JurosScreenViewModel: ViewModel() {
    //É boa prática utilizar o underscore (_) em nome de variáveis privadas
    private val_capital = MutableLiveData<String>()
    val capital: LiveData<String> = capital
}