package br.com.gabrieldargas.personalgym.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.navigation.findNavController
import br.com.gabrieldargas.personalgym.R
import br.com.gabrieldargas.personalgym.ui.base.auth.BaseAuthFragment
import com.google.firebase.auth.FirebaseAuth


class HomeFragment : BaseAuthFragment() {
    override val layout = R.layout.fragment_home
    private lateinit var btListar1: Button
    private lateinit var btListarAll: Button
    private lateinit var btcadastrarNovoExercicio: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView(view)
        registerBackPressedAction()

    }

    private fun setUpView(view: View) {
        btcadastrarNovoExercicio = view.findViewById(R.id.btcadastrarNovoExercicio)
        btcadastrarNovoExercicio.setOnClickListener {
            view.findNavController().navigate(R.id.cadastroFragment)
        }

        btListarAll = view.findViewById(R.id.btListarAll)
        btListarAll.setOnClickListener {
            view.findNavController().navigate(R.id.exercicioFragment)
        }

        //TODO - BT ONE
    }

    private fun registerBackPressedAction() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.finish()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callback)


    }
}
