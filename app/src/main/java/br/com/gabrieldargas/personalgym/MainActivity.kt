package br.com.gabrieldargas.personalgym

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.gabrieldargas.personalgym.models.Exercicio
import br.com.gabrieldargas.personalgym.ui.exercicio.MainListAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var exercicioList: ArrayList<Exercicio>
    private lateinit var mainListAdapter: MainListAdapter
    private var db = FirebaseFirestore.getInstance()
    private var mAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private lateinit var btNewExercicio: Button
    val layout = R.layout.fragment_exercicio


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_exercicio)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        exercicioList = arrayListOf()
        mainListAdapter = MainListAdapter(exercicioList)
        recyclerView.adapter = mainListAdapter
        EventChangeListener()
    }


    private fun EventChangeListener(){
        db = FirebaseFirestore.getInstance()
        db.collection("exercicios").
        addSnapshotListener(object : EventListener<QuerySnapshot> {
            override fun onEvent(
                value: QuerySnapshot?,
                error: FirebaseFirestoreException?
            ) {
                if (error != null){
                    Log.e("Firestone error!", error.message.toString())
                    return
                }
                for (dc : DocumentChange in value?.documentChanges!!){
                    if (dc.type == DocumentChange.Type.ADDED){
                        exercicioList.add(dc.document.toObject(Exercicio::class.java))
                    }
                }
                mainListAdapter.notifyDataSetChanged()
            }
        })
    }
}
