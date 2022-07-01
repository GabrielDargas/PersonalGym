package br.com.gabrieldargas.personalgym.ui.exercicio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.gabrieldargas.personalgym.R
import br.com.gabrieldargas.personalgym.databinding.FragmentExercicioBinding
import br.com.gabrieldargas.personalgym.databinding.FragmentSignupBinding
import br.com.gabrieldargas.personalgym.models.Exercicio
import br.com.gabrieldargas.personalgym.ui.base.BaseFragment
import br.com.gabrieldargas.personalgym.ui.base.auth.BaseAuthFragment
import br.com.gabrieldargas.personalgym.ui.login.LoginViewModel


class ExercicioFragment : BaseAuthFragment() {

    override val layout = R.layout.fragment_exercicio
    private lateinit var btcadastrarNovoExercicio: Button


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView(view)

    }

    private fun setUpView(view: View) {
        btcadastrarNovoExercicio = view.findViewById(R.id.btcadastrarNovoExercicio)
        btcadastrarNovoExercicio.setOnClickListener{
            findNavController().navigate(R.id.cadastroFragment)
        }
    }


}
