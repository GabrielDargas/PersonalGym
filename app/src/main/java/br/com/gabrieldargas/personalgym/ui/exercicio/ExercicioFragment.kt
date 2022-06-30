package br.com.gabrieldargas.personalgym.ui.exercicio

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.gabrieldargas.personalgym.MainListAdapter
import br.com.gabrieldargas.personalgym.databinding.FragmentExercicioBinding


class ExercicioFragment : AppCompatActivity() {

    private lateinit var binding: FragmentExercicioBinding
    private lateinit var newExercicio: NewExercicio
    private lateinit var adapter: MainListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentExercicioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
    }

    private fun initListeners() {

    }
}