package br.com.gabrieldargas.personalgym.ui.cadastro

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import br.com.gabrieldargas.personalgym.R
import br.com.gabrieldargas.personalgym.databinding.NewExercicioFragmentBinding
import br.com.gabrieldargas.personalgym.models.Exercicio
import br.com.gabrieldargas.personalgym.ui.base.auth.BaseAuthFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class NewExercicioActivity : BaseAuthFragment() {

    private var mAuth: FirebaseAuth = FirebaseAuth.getInstance()
    override val layout = R.layout.new_exercicio_fragment
    private lateinit var etNomeExercicio: EditText
    private lateinit var np_repeticoes: NumberPicker
    private lateinit var np_series: NumberPicker
    private lateinit var btCadastro: Button
    private val db = FirebaseFirestore.getInstance()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView(view)
    }

    private fun setUpView(view: View) {
        etNomeExercicio = view.findViewById(R.id.etNomeExercicio)
        btCadastro = view.findViewById(R.id.btCadastro)
        np_repeticoes = view.findViewById(R.id.np_repeticoes)
        np_series = view.findViewById(R.id.np_series)
        if (np_repeticoes != null) {
            np_repeticoes.setMinValue(6);
            np_repeticoes.setMaxValue(20);
            np_repeticoes.setWrapSelectorWheel(true);
        }
        if (np_series != null) {
            np_series.setMinValue(1);
            np_series.setMaxValue(5);
            np_series.setWrapSelectorWheel(true);
        }


        btCadastro.setOnClickListener{
            val valorSeries: Int = np_series.value
            val valorRepeticoes: Int = np_repeticoes.value
            val valorNomeExercicio: String = etNomeExercicio.text.toString()
            if (valorNomeExercicio.isEmpty()){
                Toast.makeText(requireContext(), "Nome não pode estar vazio",Toast.LENGTH_LONG).show()
            }else{
                saveInDb(valorNomeExercicio, valorSeries, valorRepeticoes)
                findNavController().navigate(R.id.exercicioFragment)
                Toast.makeText(requireContext(), "Adicionado",Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun saveInDb(
        nome: String,
        series: Int,
        repeticoes: Int
    ) {
        val exercicio = Exercicio(
            nome,
            series,
            repeticoes,
            mAuth.currentUser?.uid ?: ""
        )
        db.collection("exercicios").add(exercicio)
    }

}
