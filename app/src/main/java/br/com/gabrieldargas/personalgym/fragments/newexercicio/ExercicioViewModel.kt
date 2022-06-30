package br.com.gabrieldargas.personalgym.fragments.newexercicio

import androidx.lifecycle.ViewModel
import br.com.gabrieldargas.personalgym.domain.entity.NewExercicio
import br.com.gabrieldargas.personalgym.domain.entity.RequestState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class ExercicioViewModel : ViewModel() {

    private var mAuth : FirebaseAuth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()

    fun alteraExercicio (
        nome: String,
        series: Int,
        repeticoes: Int
    ) {
        val newExercicio = NewExercicio(
            nome,
            series,
            repeticoes,
            mAuth.currentUser?.uid ?: ""
        )
        db.collection("exercicios")
            .document(mAuth.currentUser?.uid ?: "")
            .set(newExercicio)
            .addOnSuccessListener { documentReference ->
                RequestState.Success(newExercicio)
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
                val exer = documentReference.toObject(NewExercicio::class.java) ?: NewExercicio()
                RequestState.Success(exer)
            }
            .addOnFailureListener { e ->
                RequestState.Error(Throwable(e.message))
            }

    }

}