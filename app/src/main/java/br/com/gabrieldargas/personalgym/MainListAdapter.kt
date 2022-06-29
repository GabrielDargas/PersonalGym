package br.com.gabrieldargas.personalgym

import androidx.recyclerview.widget.RecyclerView
import br.com.gabrieldargas.personalgym.ui.exercicio.ExercicioViewModel

class MainListAdapter : RecyclerView.Adapter<MainListAdapter.ViewHolder>() {

    inner class ViewHolder (val binding: ExercicioViewModel ) : RecyclerView .ViewHolder(binding.root)
}