package br.com.gabrieldargas.personalgym.data.remote.mapper

import br.com.gabrieldargas.personalgym.domain.entity.NewExercicio
import br.com.gabrieldargas.personalgym.domain.entity.NewExercicioFirebasePayload

object NewExercicioFirebasePayloadMapper {

    fun mapToNewExercicio (newExercicioFirebasePayload: NewExercicioFirebasePayload) = NewExercicio(
        nomeExercicio = newExercicioFirebasePayload.nomeExercicio ?: ""
    )
    fun mapToNewItemFirebasePayload (newExercicio: NewExercicio) = NewExercicioFirebasePayload(
        nomeExercicio = newExercicio.nomeExercicio
    )
}