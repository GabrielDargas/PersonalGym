package br.com.gabrieldargas.personalgym.fragments.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import br.com.gabrieldargas.personalgym.domain.usercases.CreateUserUseCase

class SignupViewModelFactory(
    private val createUserUseCase: CreateUserUseCase
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return modelClass.getConstructor(CreateUserUseCase::class.java).newInstance(createUserUseCase)
    }
}