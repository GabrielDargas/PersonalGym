package br.com.gabrieldargas.personalgym.ui.exercicio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.gabrieldargas.personalgym.R
import br.com.gabrieldargas.personalgym.models.Exercicio
import br.com.gabrieldargas.personalgym.models.RequestState
import br.com.gabrieldargas.personalgym.ui.base.auth.BaseAuthFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class ExercicioFragment : BaseAuthFragment() {
    override val layout = R.layout.fragment_exercicio
    private val exercicioViewModel : ExercicioViewModel by viewModels()
    private lateinit var btcadastrarNovoExercicio: Button
    private lateinit var rvExercicios : RecyclerView
    private lateinit var adapter: ExercicioListAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_exercicio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerBackPressedAction()
        setUpView(view)
        setUpObservers()



    }
    private fun setUpView(view: View){
        exercicioViewModel.getExerciciosInFireStore()
        adapter = ExercicioListAdapter()
        btcadastrarNovoExercicio = view.findViewById(R.id.btcadastrarNovoExercicio)
        btcadastrarNovoExercicio.setOnClickListener{
            view.findNavController().navigate(R.id.cadastroFragment)
        }

        rvExercicios = view.findViewById(R.id.rv_firedb)
        rvExercicios.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ExercicioListAdapter()
        }
    }




    private fun setUpObservers(){
        exercicioViewModel.exercicioState.observe(viewLifecycleOwner, Observer {
            when(it){
                is RequestState.Success -> {
                    it?.let {
                        adapter.setExercicios(it.data)
                    }
                }
                is RequestState.Error -> {
                    Toast.makeText(context, it.throwable.message, Toast.LENGTH_SHORT).show()
                }
                is RequestState.Loading -> {
                    showLoading("Aguarde um momento")
                }
            }
        })
    }

    private fun registerBackPressedAction() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                view?.findNavController()?.navigate(R.id.homeFragment)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callback)
    }

}
