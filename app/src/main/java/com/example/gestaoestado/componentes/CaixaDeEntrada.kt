package com.example.gestaoestado.componentes

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun CaixaDeEntrada(
    modifier: androidx.compose.ui.Modifier,
    label: String,
    placeholder: String,
    keyboardType: KeyboardType,
    value: String,
    atualizarValor: () -> Unit
) {
//    OutlinedTextField(
//        modifier = modifier,
//        label = {
//            Text(text = label)
//        },
//        placeholder = {
//            Text(text = placeholder)
//        },
//        keyboardOptions = KeyboardOptions(
//            keyboardType = keyboardType
//        ),
//        onValueChange = {
//                atualizarValor(it)
//        }
//    )
}