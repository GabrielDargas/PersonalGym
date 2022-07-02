package br.com.gabrieldargas.personalgym.ui.exercicio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.gabrieldargas.personalgym.R
import br.com.gabrieldargas.personalgym.models.Exercicio
import br.com.gabrieldargas.personalgym.models.RequestState
import br.com.gabrieldargas.personalgym.ui.base.auth.BaseAuthFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class ExercicioFragment : Fragment() {

    private lateinit var exercicioViewModel: ExercicioViewModel
    private lateinit var adapter: ExercicioListAdapter
    private lateinit var btcadastrarNovoExercicio: Button
    private lateinit var rvExercicios : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_exercicio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView(view)
        setUpRecyclerView()
        registerBackPressedAction()
    }

    private fun setUpRecyclerView() {
        adapter = ExercicioListAdapter()
        rvExercicios.adapter = adapter
        rvExercicios.layoutManager = LinearLayoutManager(activity)

    }

    private fun registerBackPressedAction() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                view?.findNavController()?.navigate(R.id.homeFragment)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callback)
    }


    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView(view)
        registerBackPressedAction()

    }*/

    private fun setUpView(view: View) {
        btcadastrarNovoExercicio = view.findViewById(R.id.btcadastrarNovoExercicio)
        btcadastrarNovoExercicio.setOnClickListener{
            view.findNavController().navigate(R.id.cadastroFragment)
        }
        rvExercicios = view.findViewById(R.id.rv_firedb)
    }

}
