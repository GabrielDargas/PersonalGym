package br.com.gabrieldargas.personalgym.domain.usercases

import br.com.gabrieldargas.personalgym.domain.entity.NewExercicio
import br.com.gabrieldargas.personalgym.domain.entity.RequestState
import br.com.gabrieldargas.personalgym.domain.repository.ExercicioRepository

class CreateExercicioUseCase (
    private val exercicioRepository: ExercicioRepository
    ) {
        suspend fun create(newExercicio: NewExercicio): RequestState<NewExercicio> =
            exercicioRepository.create(newExercicio)
    }