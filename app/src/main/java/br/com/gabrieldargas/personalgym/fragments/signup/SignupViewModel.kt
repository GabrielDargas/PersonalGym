package br.com.gabrieldargas.personalgym.fragments.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.gabrieldargas.personalgym.domain.entity.NewUser
import br.com.gabrieldargas.personalgym.domain.entity.RequestState
import br.com.gabrieldargas.personalgym.domain.entity.User
import br.com.gabrieldargas.personalgym.domain.usercases.CreateUserUseCase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch

class SignupViewModel(
    private val createUserUseCase: CreateUserUseCase
): ViewModel(){
    val newUserState = MutableLiveData<RequestState<User>>()
    fun create(name: String, email: String, password: String){
        viewModelScope.launch {
            newUserState.value = createUserUseCase.create(
                NewUser(
                    name,
                    email,
                    password
                )
            )
        }
    }
}