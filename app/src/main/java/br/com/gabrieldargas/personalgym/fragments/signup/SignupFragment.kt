package br.com.gabrieldargas.personalgym.fragments.signup

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import br.com.gabrieldargas.personalgym.R
import br.com.gabrieldargas.personalgym.data.remote.datasource.UserRemoteFirebaseDataSourceImpl
import br.com.gabrieldargas.personalgym.data.remote.repository.UserRepositoryImpl
import br.com.gabrieldargas.personalgym.domain.entity.NewUser
import br.com.gabrieldargas.personalgym.domain.entity.RequestState
import br.com.gabrieldargas.personalgym.domain.usercases.CreateUserUseCase
import br.com.gabrieldargas.personalgym.fragments.base.BaseFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class SignUpFragment : BaseFragment() {
    override val layout = R.layout.fragment_signup

    private val signUpViewModel: SignupViewModel by lazy {
        ViewModelProvider(
            this,
            SignupViewModelFactory(
                CreateUserUseCase(
                    UserRepositoryImpl(
                        UserRemoteFirebaseDataSourceImpl(
                            FirebaseAuth.getInstance(),
                            FirebaseFirestore.getInstance()
                        )
                    )
                )
            )
        ).get(SignupViewModel::class.java)
    }

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
            signUpViewModel.create(
                etUserNameSignUp.text.toString(),
                etEmailSignUp.text.toString(),
                etPasswordSignUp.text.toString()
            )
        }
    }

    private fun registerObserver() {
        this.signUpViewModel.newUserState.observe(viewLifecycleOwner, Observer {
            when (it) {
                is RequestState.Success -> {
                    hideLoading()
                    NavHostFragment.findNavController(this)
                        .navigate(R.id.main_nav_graph)
                }
                is RequestState.Error -> {
                    hideLoading()
                    showMessage(it.throwable.message)
                }
                is RequestState.Loading -> showLoading("Criando sua conta")
            }
        })

    }
}