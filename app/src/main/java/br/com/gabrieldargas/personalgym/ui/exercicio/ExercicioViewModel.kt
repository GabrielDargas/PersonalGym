package br.com.gabrieldargas.personalgym.ui.exercicio

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.gabrieldargas.personalgym.models.Exercicio
import br.com.gabrieldargas.personalgym.models.RequestState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObjects


class ExercicioViewModel : ViewModel() {

    private var mAuth : FirebaseAuth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()
    val exercicioState = MutableLiveData<RequestState<List<Exercicio>>>()
    var deleteState = MutableLiveData<RequestState<Boolean>>()

     fun getExerciciosInFireStore(){
         exercicioState.value = RequestState.Loading
        db.collection("exercicios")
            .get()
            .addOnSuccessListener {
                it?.let{ snapshot ->
                    val exercicios = mutableListOf<Exercicio>()
                    for (documento in snapshot.documents){
                        documento.data?.let {
                            var nome: String = documento["nome"] as String
                            var repeticoes: Long  = documento["repeticoes"] as Long
                            var series: Long  = documento["series"] as Long
                            var exercicio = Exercicio(
                                nome = nome,
                                repeticoes = repeticoes,
                                series = series
                            )
                            exercicios.add(exercicio)
                        }
                        exercicioState.value = RequestState.Success(exercicios)
                        }
                }
            }
    }


    fun deleteById(nome: String) {
        deleteState.value = RequestState.Loading
        db.collection("exercicios").document(nome).delete()
            .addOnCompleteListener {
                getExerciciosInFireStore()
                deleteState.value = RequestState.Success(true)
            }
            .addOnFailureListener { exception ->
                deleteState.value = RequestState.Error(exception)
            }
    }

}