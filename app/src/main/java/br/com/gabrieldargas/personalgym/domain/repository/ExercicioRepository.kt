package br.com.gabrieldargas.personalgym.domain.repository

import br.com.gabrieldargas.personalgym.domain.entity.NewExercicio
import br.com.gabrieldargas.personalgym.domain.entity.RequestState

interface ExercicioRepository {

    suspend fun create(newExercicio: NewExercicio): RequestState<NewExercicio>

}