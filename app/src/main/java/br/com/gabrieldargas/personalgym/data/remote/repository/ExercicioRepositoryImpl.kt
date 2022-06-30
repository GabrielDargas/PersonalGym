package br.com.gabrieldargas.personalgym.data.remote.repository

import br.com.gabrieldargas.personalgym.data.remote.datasource.ExercicioRemoteDataSource
import br.com.gabrieldargas.personalgym.domain.entity.NewExercicio
import br.com.gabrieldargas.personalgym.domain.entity.RequestState
import br.com.gabrieldargas.personalgym.domain.repository.ExercicioRepository

class ExercicioRepositoryImpl(

    private val exercicioRemoteDataSource: ExercicioRemoteDataSource
    ) : ExercicioRepository {
        override suspend fun create(newExercicio: NewExercicio): RequestState<NewExercicio> {
            return exercicioRemoteDataSource.create(newExercicio)
        }
}