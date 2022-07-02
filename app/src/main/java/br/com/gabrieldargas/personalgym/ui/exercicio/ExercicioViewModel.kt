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

    init {
        getExerciciosInFireStore()
    }

    fun deleteAll(){

    }

    fun deleteOne(exercicio: Exercicio){

    }

    fun alteraExercicio (
        nome: String,
        series: Int,
        repeticoes: Int
    ) {
        val exercicio = Exercicio(
            nome,
            series,
            repeticoes,
            mAuth.currentUser?.uid ?: ""
        )
        db.collection("exercicios")
            .document(mAuth.currentUser?.uid ?: "")
            .set(exercicio)
            .addOnSuccessListener { documentReference ->
                RequestState.Success(exercicio)
            }.addOnFailureListener { e ->
                RequestState.Error(
                    Throwable(e.message)
                )
            }
    }


    fun getExerciciosInFireStore(){
        db.collection("exercicios")
            .get()
            .addOnSuccessListener { documentReference ->
                val exercicio = documentReference.toObjects<Exercicio>()
                exercicioState.value = RequestState.Success(exercicio)
            }
            .addOnFailureListener{ it ->
                exercicioState.value = RequestState.Error(Throwable(it.message))
            }
    }
}