package br.com.gabrieldargas.personalgym.models

import com.google.firebase.firestore.Exclude

data class NewUser(
    val username: String? = null,
    val email: String? = null,
    @get:Exclude val password: String? = null
)