package br.com.gabrieldargas.personalgym.ui.exercicio

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.gabrieldargas.personalgym.R
import br.com.gabrieldargas.personalgym.databinding.FragmentExercicioBinding
import br.com.gabrieldargas.personalgym.models.Exercicio

class  ExercicioListAdapter(
    var exercicios: List<Exercicio> = listOf(),
    var onClickListener: (exercicio: Exercicio) -> Unit = {}
) : RecyclerView.Adapter<ExercicioListAdapter.ViewHolder>() {



    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        private lateinit var exercicio: Exercicio
        var nomeExercicio: TextView = itemView.findViewById(R.id.tvnomeexercicio)
        var numeroSeries: TextView = itemView.findViewById(R.id.tvNumeroSeries)
        var numeroRepeticoes: TextView = itemView.findViewById(R.id.tvNumeroRepeticoes)

        init {
            itemView.setOnClickListener{
                if(::exercicio.isInitialized){
                    onClickListener(exercicio)
                }
            }
        }
        fun bindView(exercicio: Exercicio){
            this.exercicio = exercicio
            nomeExercicio.text = exercicio.nome
            numeroSeries.text = exercicio.series.toString()
            numeroRepeticoes.text = exercicio.repeticoes.toString()
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.exercicios_list_user, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder (viewHolder: ViewHolder, i: Int) {
        viewHolder.bindView(exercicios[i])
    }

    override fun getItemCount(): Int {
        return exercicios.size
    }

}