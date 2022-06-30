package br.com.gabrieldargas.personalgym


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.gabrieldargas.personalgym.databinding.ExercicioItemBinding
import br.com.gabrieldargas.personalgym.models.Exercicio

class MainListAdapter : RecyclerView.Adapter<MainListAdapter.ViewHolder>() {

    inner class ViewHolder (val binding: ExercicioItemBinding ) :
        RecyclerView .ViewHolder(binding. root)
    private var exercicios = emptyList<Exercicio>()
    override fun onCreateViewHolder (parent: ViewGroup , viewType: Int):
            ViewHolder {
        val binding =
            ExercicioItemBinding .inflate( LayoutInflater .from(parent. context),
                parent, false)
        return ViewHolder( binding)
    }

    override fun onBindViewHolder (holder: ViewHolder , position: Int) {
        with(holder) {
            with(exercicios [position]) {
                binding.tvNomeExercicio.text = this.nome
                binding.tvNumeroSeries.text = this.series.toString()
                binding.tvNumeroRepeticoes.text = this.repeticoes.toString()
            }
        }
    }
    internal fun setProducts (exercicios: List<Exercicio>) {
        this.exercicios = exercicios
        notifyDataSetChanged()
    }
    override fun getItemCount (): Int {
        return exercicios .size
    }
}
