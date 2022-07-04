package br.com.gabrieldargas.personalgym.ui.exercicio

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.gabrieldargas.personalgym.R
import br.com.gabrieldargas.personalgym.models.Exercicio
import br.com.gabrieldargas.personalgym.models.RequestState
import br.com.gabrieldargas.personalgym.ui.base.auth.BaseAuthFragment


class ExercicioFragment : BaseAuthFragment() {
    override val layout = R.layout.fragment_exercicio
    private val exercicioViewModel : ExercicioViewModel by viewModels()
    private lateinit var btcadastrarNovoExercicio: Button
    private lateinit var rvExercicios : RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerBackPressedAction()
        setUpView(view)
        setUpObservers()
    }

    @SuppressLint("ResourceType")
    private fun setUpView(view: View){
        btcadastrarNovoExercicio = view.findViewById(R.id.btcadastrarNovoExercicio)
        rvExercicios = view.findViewById(R.id.rv_firedb)
        rvExercicios.layoutManager = LinearLayoutManager(context)
        setUpListener()

    }

    private fun setUpListener() {
        exercicioViewModel.getExerciciosInFireStore()

        btcadastrarNovoExercicio.setOnClickListener {
           findNavController().navigate(R.id.cadastroFragment)
        }
        rvExercicios.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ExercicioListAdapter()
        }
    }

    private fun setUpObservers(){
        exercicioViewModel.exercicioState.observe(viewLifecycleOwner, Observer {
            when(it){
                is RequestState.Success -> {
                  uploadRecycleView(it.data)
                    hideLoading()
                }
                is RequestState.Error -> {
                    hideLoading()
                    Toast.makeText(context, it.throwable.message, Toast.LENGTH_SHORT).show()
                }
                is RequestState.Loading -> {
                    showLoading(getString(R.string.loading_message_processing))
                }
            }
        })

        exercicioViewModel.deleteState.observe(viewLifecycleOwner, Observer {
            when (it) {
                is RequestState.Success -> {
                    showMessage(getString(R.string.delete_succefuly))
                }
                is RequestState.Error -> {
                    hideLoading()
                    showMessage(it.throwable.message)
                }
                is RequestState.Loading -> {
                    showLoading(getString(R.string.loading_message_processing))
                }
            }
        })
    }

    private fun uploadRecycleView(exercicios: List<Exercicio>) {
        exercicios.forEach(::println)
        var myAdapter = ExercicioListAdapter(exercicios)
        rvExercicios.adapter = myAdapter
        myAdapter.onClickListener = { select ->
            select.nome?.let { showDialogMenu(select) }
        }
    }

    fun showDialogMenu(exercicio: Exercicio) {
        val bundle = Bundle()
        bundle.putString("exercicioNome", exercicio.nome)
        val builder = AlertDialog.Builder(context)
        val option = arrayOf(getString(R.string.edit), getString(R.string.delete))
        builder.setItems(option) { dialog, which ->
            when (which) {
                //todo (navegar para alterar cadastro)
                0 -> findNavController().navigate(R.id.homeFragment, bundle)
                1 -> showDialogDel(exercicio.nome ?: "")
            }
        }
        builder.create().show()
    }


    private fun showDialogDel(nome: String) {
        val builder = AlertDialog.Builder(context)
            .setTitle(getString(R.string.app_name))
            .setMessage(getString(R.string.want_to_delete_menssage))
            .setPositiveButton(android.R.string.yes) { dialog, which ->
                exercicioViewModel.deleteById(nome)
            }
            .setNegativeButton(android.R.string.cancel, null)
        builder.create().show()
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

