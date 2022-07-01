package br.com.gabrieldargas.personalgym.fragments.newexercicio

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.gabrieldargas.personalgym.domain.entity.NewExercicio
import br.com.gabrieldargas.personalgym.domain.entity.RequestState
import br.com.gabrieldargas.personalgym.domain.usercases.CreateExercicioUseCase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch


class NewExercicioViewModel(
    private val createExercicioUseCase: CreateExercicioUseCase
): ViewModel(){

    val newExercicioState = MutableLiveData<RequestState<NewExercicio>>()

    fun create (nome: String){
        viewModelScope.launch {
            newExercicioState.value = createExercicioUseCase.create(
                NewExercicio(
                    nome
                )
            )
        }
    }
}