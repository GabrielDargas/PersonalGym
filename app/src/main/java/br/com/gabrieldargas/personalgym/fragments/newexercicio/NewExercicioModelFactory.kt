package br.com.gabrieldargas.personalgym.fragments.newexercicio

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.gabrieldargas.personalgym.domain.usercases.CreateExercicioUseCase

class NewExercicioModelFactory (
    private val createExercicioUseCase: CreateExercicioUseCase
        ): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(CreateExercicioUseCase::class.java).newInstance(createExercicioUseCase)
    }
        }