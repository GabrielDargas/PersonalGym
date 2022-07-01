package br.com.gabrieldargas.personalgym.ui.exercicio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.gabrieldargas.personalgym.R
import br.com.gabrieldargas.personalgym.databinding.FragmentExercicioBinding
import br.com.gabrieldargas.personalgym.databinding.FragmentSignupBinding
import br.com.gabrieldargas.personalgym.models.Exercicio
import br.com.gabrieldargas.personalgym.ui.base.BaseFragment
import br.com.gabrieldargas.personalgym.ui.base.auth.BaseAuthFragment
import br.com.gabrieldargas.personalgym.ui.login.LoginViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class ExercicioFragment : BaseAuthFragment() {

    private var mAuth: FirebaseAuth = FirebaseAuth.getInstance()
    override val layout = R.layout.fragment_exercicio
    private lateinit var btcadastrarNovoExercicio: Button
    private val db = FirebaseFirestore.getInstance()
    private lateinit var recyclerView : RecyclerView}
    /*private var exercicios = emptyList<Exercicio>()/*

    /*override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_exercicio, container, false)
        recyclerView = view.findViewById(R.id.rv_firedb)
        recyclerView.setHasFixedSize(true)
        recyclerView.setLayoutManager(LinearLayoutManager(view.getContext()))
        recyclerView.setAdapter(ExercicioListAdapter)
        return view
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView(view)

    }

    private fun setUpView(view: View) {
        btcadastrarNovoExercicio = view.findViewById(R.id.btcadastrarNovoExercicio)
        btcadastrarNovoExercicio.setOnClickListener{
            findNavController().navigate(R.id.cadastroFragment)
        }*/

    }


}*/