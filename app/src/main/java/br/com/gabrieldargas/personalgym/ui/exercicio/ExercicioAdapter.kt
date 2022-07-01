package br.com.gabrieldargas.personalgym.ui.exercicio

import android.R
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.gabrieldargas.personalgym.models.Exercicio

class ExercicioAdapter(private var exercicioList: MutableList<Exercicio>) : RecyclerView.Adapter<ExercicioAdapter.ExercicioViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ExercicioAdapter.ExercicioViewHolder {

        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout., parent, false)

    }
}