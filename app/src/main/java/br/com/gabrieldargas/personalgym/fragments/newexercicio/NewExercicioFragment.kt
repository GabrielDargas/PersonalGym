package br.com.gabrieldargas.personalgym.fragments.newexercicio

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import br.com.gabrieldargas.personalgym.R
import br.com.gabrieldargas.personalgym.data.remote.datasource.ExercicioRemoteDataSourceImpl
import br.com.gabrieldargas.personalgym.data.remote.repository.ExercicioRepositoryImpl
import br.com.gabrieldargas.personalgym.domain.usercases.CreateExercicioUseCase
import br.com.gabrieldargas.personalgym.fragments.base.auth.BaseAuthFragment
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class NewExercicioFragment : BaseAuthFragment() {
    override val layout = R.layout.fragment_new_exercicio1

    private val newExercicioViewModel: NewExercicioViewModel by lazy {
        ViewModelProvider(
            this,
            NewExercicioModelFactory(
                CreateExercicioUseCase(
                    ExercicioRepositoryImpl(
                        ExercicioRemoteDataSourceImpl(
                            FirebaseFirestore.getInstance()
                        )
                    )
                )
            )
        ).get(NewExercicioViewModel::class.java)
    }

    private lateinit var etNameNewExercicio : EditText
    private lateinit var tvNewExercicio : TextView
    private lateinit var btSalveNewExercicio : Button
    private lateinit var btNewVoltar : Button


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView(view)
    }

    private fun setUpView(view: View) {
        etNameNewExercicio = view.findViewById(R.id.etNameNewExercicio)
        tvNewExercicio = view.findViewById(R.id.tvNewExercicio)
        btSalveNewExercicio = view.findViewById(R.id.btSalveNewExercicio)
        btNewVoltar = view.findViewById(R.id.btNewVoltar)

        btSalveNewExercicio.setOnClickListener{
            newExercicioViewModel.create(
                etNameNewExercicio.text.toString()
            )
            findNavController().navigate(//TODO)
        }
        btNewVoltar.setOnClickListener{
            findNavController().navigate(//TODO)
        }
    }

}