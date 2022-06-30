package br.com.gabrieldargas.personalgym.fragments.exerciciolistitem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import br.com.gabrieldargas.personalgym.R
import br.com.gabrieldargas.personalgym.fragments.base.auth.BaseAuthFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class ListItemFragment : BaseAuthFragment() {

    override val layout = R.layout.fragment_exercicio_list_item

    private lateinit var btListNewItem: Button
    private lateinit var btListNewBack: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpView(view)
    }

    private fun setUpView(view: View) {


        btListNewItem = view.findViewById(R.id.btNewExercicio)
        btListNewBack = view.findViewById(R.id.btVoltar)

        btListNewItem.setOnClickListener {
            findNavController().navigate(R.id.action_listItemFragment_to_newItemFragment)
        }

        btListNewBack.setOnClickListener {
            findNavController().navigate(R.id.action_listItemFragment_to_homeFragment)
        }

    }

}
