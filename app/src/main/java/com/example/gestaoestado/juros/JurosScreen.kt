package com.example.gestaoestado.juros

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gestaoestado.componentes.CaixaDeEntrada

@Composable
fun JurosScreen(
    modifier: Modifier,
    jurosScreenViewModel: JurosScreenViewModel,
    it: String
) {
//        var capital by remember {
//            mutableStateOf("")
//        }

    val capital by jurosScreenViewModel.capital.observeAsState(initial = "")

    val taxa by jurosScreenViewModel.taxa.observeAsState(initial = "")

    val tempo by jurosScreenViewModel.tempo.observeAsState(initial = "")

    val juros by jurosScreenViewModel.juros.observeAsState(initial = 0.0)

    val montante by jurosScreenViewModel.montante.observeAsState(initial = 0.0)

        Box {
            Column(
                modifier = modifier.fillMaxSize(),
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .background(color = Color(136, 38, 199, 255))
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Calculadora Juros Simples",
                            fontSize = 24.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 32.dp)
                    ) {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .offset(y = (-30).dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFFF9F6F6)
                            ),
                            elevation = CardDefaults.cardElevation(4.dp),
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(24.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                Text(
                                    text = "Dados do investimento",
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold
                                )

                            OutlinedTextField(
                                value = capital,
                                onValueChange = {
                                    jurosScreenViewModel.onCapitalChanged(it)
                                },
                                modifier = Modifier.fillMaxWidth(),
                                label = { Text(text = "Valor investimento") },
                                placeholder = { Text(text = "Quanto deseja investir?") },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
                            )

                                CaixaDeEntrada(
                                    modifier = Modifier.fillMaxWidth(),
                                    label = "Valor investido",
                                    placeholder = "Quanto deseja investir?",
                                    keyboardType = KeyboardType.Decimal,
                                    value = capital,
                                    atualizarValor = {
                                        jurosScreenViewModel.onCapitalChanged(it)
                                    }
                                )

                                CaixaDeEntrada(
                                    modifier = Modifier.fillMaxWidth(),
                                    label = "Taxa de juros mensal",
                                    placeholder = "Qual a taxa de juros mensal?",
                                    keyboardType = KeyboardType.Decimal,
                                    value = taxa,
                                    atualizarValor = {
                                        jurosScreenViewModel.onTaxaChanged(novaTaxa = it)
                                    }
                                )

                                CaixaDeEntrada(
                                    modifier = Modifier.fillMaxWidth(),
                                    label = "Período em meses",
                                    placeholder = "Qual o tempo em meses?",
                                    keyboardType = KeyboardType.Decimal,
                                    value = tempo,
                                    atualizarValor = {
                                        jurosScreenViewModel.onTempoChanged(novoTempo = it)
                                    }
                                )

                                OutlinedTextField(
                                    value = taxa,
                                    onValueChange = {
                                        jurosScreenViewModel.onTaxaChanged(it)
                                    },
                                    modifier = Modifier.fillMaxWidth(),
                                    label = { Text(text = "Taxa de juros mensal") },
                                    placeholder = { Text(text = "Qual a taxa de juros mensal?") },
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
                                )

                                OutlinedTextField(
                                    value = tempo,
                                    onValueChange = {
                                        jurosScreenViewModel.onTempoChanged(it)
                                    },
                                    modifier = Modifier.fillMaxWidth(),
                                    label = { Text(text = "Período em meses") },
                                    placeholder = { Text(text = "Qual o tempo em meses?") },
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
                                )

                                Button(
                                    onClick = {
                                        jurosScreenViewModel.calcularJurosInvestimento()

                                        jurosScreenViewModel.calcularMontanteInvestimento()
                                    },
                                    modifier = Modifier.fillMaxWidth()
                                        .height(48.dp)
                                ) {
                                    Text(
                                        text = "CALCULAR",
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White,
                                        fontSize = 14.sp
                                    )
                                }
                            }
                        }

                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFF329F6B)
                            ),
                            elevation = CardDefaults.cardElevation(4.dp)
                        ) {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(16.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(24.dp)
                            ) {

                            }
                            Text(
                                text = "Resultado",
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 28.sp,
                                textAlign = TextAlign.Start
                            )

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                Text(
                                    text = "Juros",
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    fontSize = 24.sp,
                                    textAlign = TextAlign.Start
                                )

                                Text(
                                    text = "$juros",
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    fontSize = 24.sp
                                )
                            }


                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                Text(
                                    text = "Montante",
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    fontSize = 24.sp,
                                    textAlign = TextAlign.Start
                                )

                                Text(
                                    text = "$montante",
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    fontSize = 24.sp
                                )
                            }
                        }
                    }
                }
            }
        }
}