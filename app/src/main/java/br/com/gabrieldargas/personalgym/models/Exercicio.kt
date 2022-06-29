package br.com.gabrieldargas.personalgym.models


data class Exercicio (
    val nome: String = "",
    val series: Int = 0,
    val repeticoes: Int = 0,
    var userId: String = ""


)