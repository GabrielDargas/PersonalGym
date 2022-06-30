package br.com.gabrieldargas.personalgym.fragments.newexercicio


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.gabrieldargas.personalgym.R
import br.com.gabrieldargas.personalgym.domain.entity.NewExercicio

class MainListAdapter(private val exerciciosList: List<NewExercicio>) : RecyclerView.Adapter<MainListAdapter.ViewHolder>() {

    inner class ViewHolder (itemView : View ) : RecyclerView.ViewHolder(itemView){
        val nome : TextView = itemView.findViewById(R.id.tvNomeExercicio)
        val series : TextView = itemView.findViewById(R.id.tvNumeroSeries)
        val repeticoes : TextView = itemView.findViewById(R.id.tvNumeroRepeticoes)
    }
    override fun onBindViewHolder (holder: ViewHolder, position: Int) {
       val newExercicio : NewExercicio = exerciciosList[position]
        holder.nome.text = newExercicio.nome
        holder.series.text = newExercicio.series.toString()
        holder.repeticoes.text = newExercicio.repeticoes.toString()
    }
    override fun getItemCount (): Int {
       return exerciciosList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.exercicio_item, parent, false)
        return  ViewHolder(itemView)
    }
}
