package br.com.gabrieldargas.personalgym.form

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.gabrieldargas.personalgym.R
import br.com.gabrieldargas.personalgym.domain.entity.NewExercicio

class NewExercicioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_exercicio)

        btSalveNewExercicio.setOnClickListener {
            val newExercicio = NewExercicio()
            val userid = intent.getStringExtra("userId")

            newExercicio.nome = etNameNewExercicio.text.toString()
            newExercicio.series = Integer.parseInt(etSeriesNewExercicio.text.toString())
            newExercicio.repeticoes = Integer.parseInt(etRepeticoesNewExercicio.text.toString()

            val context = this

            val call = RetrofitInitializer().contactService().addContact(userid, newContact)

            call.enqueue(object: Callback<Contact?> {
                override fun onResponse(call: Call<Contact?>?,
                                        response: Response<Contact?>) {
                    if (response.isSuccessful) {
                        finish()
                        response?.let {
                            val Contact = it.body()
                        }
                        Toast.makeText(context, R.string.contact_saved, Toast.LENGTH_SHORT).show()
                    }else {
                        Toast.makeText(context, R.string.failed_save, Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Contact?>?, t: Throwable?) {
                    Toast.makeText(context, R.string.failed_save, Toast.LENGTH_SHORT).show()
                    Log.e("onFailure error", t?.message)
                }
            })
        }
    }
}

}