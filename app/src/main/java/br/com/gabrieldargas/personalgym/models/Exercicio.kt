package br.com.gabrieldargas.personalgym.models

import com.google.firebase.firestore.Exclude


data class Exercicio (
    @get: Exclude var id: String? = null,
    val nome: String = "",
    val series: Long = 0,
    val repeticoes: Long = 0,
    var userId: String = ""
)