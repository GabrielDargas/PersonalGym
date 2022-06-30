package br.com.gabrieldargas.personalgym.fragments.newexercicio

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.gabrieldargas.personalgym.R
import br.com.gabrieldargas.personalgym.domain.entity.NewExercicio
import br.com.gabrieldargas.personalgym.fragments.base.auth.BaseAuthFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class ExercicioFragment : BaseAuthFragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var newExercicioList: ArrayList<NewExercicio>
    private lateinit var mainListAdapter: MainListAdapter
    private var db = FirebaseFirestore.getInstance()
    private var mAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private lateinit var btNewExercicio: Button
    val layout = R.layout.fragment_exercicio


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        newExercicioList = arrayListOf()
        mainListAdapter = MainListAdapter(newExercicioList)
        recyclerView.adapter = mainListAdapter
        EventChangeListener()
    }


    private fun EventChangeListener(){
        db = FirebaseFirestore.getInstance()
        db.collection("exercicios").orderBy("timestamp", Query.Direction.ASCENDING).
                addSnapshotListener(object : EventListener<QuerySnapshot>{
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
                                newExercicioList.add(dc.document.toObject(NewExercicio::class.java))
                            }
                        }
                        mainListAdapter.notifyDataSetChanged()
                    }
                })
    }
}









