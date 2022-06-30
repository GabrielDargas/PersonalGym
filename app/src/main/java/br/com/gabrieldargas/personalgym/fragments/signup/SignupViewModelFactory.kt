package br.com.gabrieldargas.personalgym.fragments.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.gabrieldargas.personalgym.domain.usercases.CreateUserUseCase

class SignupViewModelFactory(
    private val createUserUseCase: CreateUserUseCase
): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(CreateUserUseCase::class.java).newInstance(createUserUseCase)
    }
}