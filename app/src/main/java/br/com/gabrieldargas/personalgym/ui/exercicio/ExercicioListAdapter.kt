package br.com.gabrieldargas.personalgym.ui.exercicio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.gabrieldargas.personalgym.R
import br.com.gabrieldargas.personalgym.databinding.FragmentExercicioBinding
import br.com.gabrieldargas.personalgym.models.Exercicio

class  ExercicioListAdapter : RecyclerView.Adapter<ExercicioListAdapter.ViewHolder>() {

    private var exercicios = emptyList<Exercicio>()

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var nomeExercicio: TextView
        var numeroSeries: TextView
        var numeroRepeticoes: TextView


        init {
            nomeExercicio = itemView.findViewById(R.id.tvnomeexercicio)
            numeroSeries = itemView.findViewById(R.id.tvNumeroSeries)
            numeroRepeticoes = itemView.findViewById(R.id.tvNumeroRepeticoes)

            itemView.setOnClickListener{
                //TODO AO CLICAR IR PARA LISTAR ONE

                //Example code
                /*itemView.setOnClickListener {
                    var position: Int = getAdapterPosition()
                    val context = itemView.context
                    val intent = Intent(context, DetailPertanyaan::class.java).apply {
                        putExtra("NUMBER", position)
                        putExtra("CODE", itemKode.text)
                        putExtra("CATEGORY", itemKategori.text)
                        putExtra("CONTENT", itemIsi.text)
                    }
                    context.startActivity(intent)
                }*/
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.exercicios_list_user, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder (viewHolder: ViewHolder, i: Int) {
        viewHolder.nomeExercicio.text = exercicios[i].nome
        viewHolder.numeroRepeticoes.text = exercicios[i].repeticoes.toString()
        viewHolder.numeroSeries.text = exercicios[i].series.toString()
    }

    override fun getItemCount(): Int {
        return exercicios.size
    }

}