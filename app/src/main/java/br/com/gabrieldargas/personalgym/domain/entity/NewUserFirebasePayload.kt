package br.com.gabrieldargas.personalgym.domain.entity

import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
data class NewUserFirebasePayload(
    val name: String? = null,
    val email: String? = null,
    @get:Exclude val password: String? = null
)