package br.com.gabrieldargas.personalgym.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import br.com.gabrieldargas.personalgym.R
import br.com.gabrieldargas.personalgym.fragments.base.auth.BaseAuthFragment

class HomeFragment : BaseAuthFragment() {
    override val layout = R.layout.fragment_home

    private lateinit var tvHomeHelloUser: TextView
    private lateinit var btListAll: Button
    private lateinit var btNewItem: Button
    private lateinit var btClose: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpView(view)

        registerBackPressedAction()
    }

    private fun setUpView(view: View) {
        tvHomeHelloUser = view.findViewById(R.id.tvNewItem)
        btListAll = view.findViewById(R.id.btListAll)
        btNewItem = view.findViewById(R.id.btNewItem)
        btClose = view.findViewById(R.id.btClose)

        btListAll.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_listItemFragment)
        }

        btNewItem.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_newExercicioFragment)
        }

        btClose.setOnClickListener {
            activity?.finish()
        }

    }

    private fun registerBackPressedAction() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.finish()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }
}
