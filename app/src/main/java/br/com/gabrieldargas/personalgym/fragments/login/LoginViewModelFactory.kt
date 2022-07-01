package br.com.gabrieldargas.personalgym.fragments.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.gabrieldargas.personalgym.domain.usercases.LoginUseCase
import br.com.gabrieldargas.personalgym.domain.usercases.ResetPasswordUseCase

class LoginViewModelFactory (
    private val loginUseCase : LoginUseCase ,
    private val resetPasswordUseCase : ResetPasswordUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(
            LoginUseCase ::class.java,
            ResetPasswordUseCase::class.java
        ).newInstance( loginUseCase , resetPasswordUseCase )
    }
}