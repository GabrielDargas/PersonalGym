package br.com.gabrieldargas.personalgym.data.remote.datasource

import br.com.gabrieldargas.personalgym.data.remote.mapper.NewExercicioFirebasePayloadMapper
import br.com.gabrieldargas.personalgym.domain.entity.NewExercicio
import br.com.gabrieldargas.personalgym.domain.entity.RequestState
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.tasks.await


@ExperimentalCoroutinesApi
class ExercicioRemoteDataSourceImpl (
    private val firebaseFirestore: FirebaseFirestore
        ): ExercicioRemoteDataSource{
    override suspend fun create(newExercicio : NewExercicio):RequestState<NewExercicio>{
        val newExercicioFirebasePayload =
            NewExercicioFirebasePayloadMapper.mapToNewItemFirebasePayload(newExercicio)
        return try {
            firebaseFirestore.collection("exercicios")
                .document(newExercicio.nomeExercicio)
                .set(newExercicioFirebasePayload)
                .await()
            RequestState.Success(newExercicio)
        } catch ( e: Exception){
            RequestState.Error(e)
        }

    }

    
}