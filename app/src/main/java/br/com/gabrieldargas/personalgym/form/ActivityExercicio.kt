package br.com.gabrieldargas.personalgym.form

import android.content.Intent
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.gabrieldargas.personalgym.R
import com.google.firebase.auth.FirebaseAuth
import com.squareup.okhttp.Response
import javax.security.auth.callback.Callback

class ActivityExercicio : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private var userid = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercicio)
        mAuth = FirebaseAuth.getInstance()

        val exercicioId =intent.getIntExtra("exercicioId", 0)
        val exercicioNome =intent.getStringExtra("exercicioNome")
        val exercicioSeries =intent.getIntExtra("exercicioSeries",0)
        val exercicioRepeticoes =intent.getIntExtra("exerciciosRepeticoes", 0)

        tvNomeExercicio.text = exercicioNome
        tvNumeroRepeticoes.text = exercicioRepeticoes
        tvNumeroSeries.text = exercicioSeries

        btUpdateExercicio.setOnClickListener{
            val proximaTela = Intent(this, UpdateExercicioActivity::class.java)
            proximaTela.putExtra("exercicioId", exercicioId)
            proximaTela.putExtra("exercicioNome", exercicioNome)
            proximaTela.putExtra("exercicioRepeticoes", exercicioRepeticoes)
            proximaTela.putExtra("exercicioSeries", exercicioSeries)

            startActivity(proximaTela)
            finish()
        }

        btDeleteExercicio.setOnClickListener {
            userid = mAuth.currentUser?.uid ?: ""
            deleteExercicio(exercicioId)
        }


        private fun deleteExercicio(exercicioId: Int) {
            val context = this

            val call = RetrofitInitializer().exercicioService().deleteExercicio(userid, exercicioId)
            call.enqueue(object : Callback<Unit?> {
                override fun onResponse(
                    call: Call<Unit?>?, response: Response<Unit?>
                ) {
                    if (response.isSuccessful) {
                        finish()
                        response?.let {
                            val Exercicio = it.body()
                        }
                        Toast.makeText(context, R.string.exercicio_deleted, Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        Toast.makeText(context, R.string.failed_delete, Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Unit?>?, t: Throwable?) {
                    Toast.makeText(context, R.string.failed_delete, Toast.LENGTH_SHORT).show()
                    Log.e("onFailure error", t?.message.toString())
                }
            })
        }
}