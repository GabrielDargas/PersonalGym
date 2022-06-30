package br.com.gabrieldargas.personalgym.ui.exercicio

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.gabrieldargas.personalgym.models.Exercicio
import br.com.gabrieldargas.personalgym.models.RequestState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore


class NewExercicio : ViewModel() {

    private var mAuth : FirebaseAuth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()

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

    fun getExercicio(){
        db.collection("exercicio")
            .document(mAuth.currentUser?.uid ?: "")
            .get()
            .addOnSuccessListener { documentReference ->
                val exer = documentReference.toObject(Exercicio::class.java) ?: Exercicio()
                RequestState.Success(exer)
            }
            .addOnFailureListener { e ->
                RequestState.Error(Throwable(e.message))
            }

    }

}