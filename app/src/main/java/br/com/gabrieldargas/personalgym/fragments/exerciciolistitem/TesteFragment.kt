package br.com.gabrieldargas.personalgym.fragments.exerciciolistitem

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.gabrieldargas.personalgym.R

class TesteFragment : Fragment() {

    companion object {
        fun newInstance() = TesteFragment()
    }

    private lateinit var viewModel: TesteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_teste, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TesteViewModel::class.java)
        // TODO: Use the ViewModel
    }

}