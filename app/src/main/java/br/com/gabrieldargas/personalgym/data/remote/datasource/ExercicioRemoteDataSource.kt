package br.com.gabrieldargas.personalgym.data.remote.datasource

import br.com.gabrieldargas.personalgym.domain.entity.NewExercicio
import br.com.gabrieldargas.personalgym.domain.entity.RequestState

interface ExercicioRemoteDataSource {
    suspend fun create(newExercicio: NewExercicio): RequestState<NewExercicio>

    suspend fun getAll(): RequestState<NewExercicio>

    suspend fun resetPassword(email: String): RequestState<String>
}