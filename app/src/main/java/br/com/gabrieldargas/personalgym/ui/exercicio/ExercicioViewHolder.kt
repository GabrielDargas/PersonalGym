package br.com.gabrieldargas.personalgym.ui.exercicio

import android.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.gabrieldargas.personalgym.models.Exercicio


class RecyclerAdapter (
    private val exercicios: List<Exercicio>
        ) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemNome = itemView.findViewById<TextView>(R.id.tvnomeexercicio)
        val itemSeries = itemView.findViewById<TextView>(R.id.tvNumeroSeries)
        val itemRepeticoes = itemView.findViewById<TextView>(R.id.tvNumeroRepeticoes)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val exercicioView = inflater.inflate(R.layout.exercicios_list_user, parent, false)
        return ViewHolder(exercicioView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}