package br.com.gabrieldargas.personalgym.domain.entity

import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
data class NewExercicioFirebasePayload(
    val nomeExercicio: String? = ""
)