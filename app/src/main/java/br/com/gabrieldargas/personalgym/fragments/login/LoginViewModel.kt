package br.com.gabrieldargas.personalgym.fragments.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.gabrieldargas.personalgym.domain.entity.RequestState
import br.com.gabrieldargas.personalgym.domain.entity.User
import br.com.gabrieldargas.personalgym.domain.entity.UserLogin
import br.com.gabrieldargas.personalgym.domain.usercases.LoginUseCase
import br.com.gabrieldargas.personalgym.domain.usercases.ResetPasswordUseCase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase ,
    private val resetPasswordUseCase: ResetPasswordUseCase
) : ViewModel() {
    val loginState = MutableLiveData<RequestState<User>>()

    fun doLogin(email: String, password: String) {
        viewModelScope.launch {
            loginState.value = loginUseCase.doLogin(
                UserLogin(email, password)
            )
        }
    }

    val resetPasswordState = MutableLiveData<RequestState<String>>()

    fun resetPassword(email: String) {
        viewModelScope.launch {
            resetPasswordState.value =
                resetPasswordUseCase.resetPassword(email)
        }
    }

}