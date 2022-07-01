package br.com.gabrieldargas.personalgym.ui.signup

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import br.com.gabrieldargas.personalgym.R
import br.com.gabrieldargas.personalgym.models.NewUser
import br.com.gabrieldargas.personalgym.models.RequestState
import br.com.gabrieldargas.personalgym.ui.base.BaseFragment


class SignUpFragment : BaseFragment(){
    override val layout = R.layout.fragment_signup

    private val signUpViewModel: SignupViewModel by viewModels()

    private lateinit var etUserNameSignUp: EditText
    private lateinit var etEmailSignUp: EditText
    private lateinit var etPasswordSignUp: EditText
    private lateinit var btCreateAccount: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView(view)
        registerObserver()
    }
    private fun setUpView(view: View) {
        etUserNameSignUp = view.findViewById(R.id.etUserNameSignUp)
        etEmailSignUp = view.findViewById(R.id.etEmailSignUp)
        etPasswordSignUp = view.findViewById(R.id.etPasswordSignUp)
        btCreateAccount = view.findViewById(R.id.btCreateAccount)
        setUpListener()
    }
    private fun setUpListener() {
        btCreateAccount.setOnClickListener {
            val newUser = NewUser(
                etUserNameSignUp.text.toString(),
                etEmailSignUp.text.toString(),
                etPasswordSignUp.text.toString()
            )
            signUpViewModel.signUp(
                newUser
            )
        }
    }
    private fun registerObserver() {
        this.signUpViewModel.signUpState.observe(viewLifecycleOwner, Observer {
            when (it) {
                is RequestState.Success -> {
                    hideLoading()
                    NavHostFragment.findNavController(this)
                        .navigate(R.id.main_nav_graph)
                } is RequestState.Error -> {
                hideLoading()
                showMessage(it.throwable.message)
            } is RequestState.Loading -> showLoading("Criando sua conta")
            }
        })
    }
}
