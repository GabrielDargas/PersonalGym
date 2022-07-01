package br.com.gabrieldargas.personalgym.domain.entity

import com.google.firebase.firestore.Exclude

data class NewUser(
    val name: String,
    val email: String,
    val password: String
)