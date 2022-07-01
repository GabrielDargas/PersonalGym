package br.com.gabrieldargas.personalgym.api

import retrofit2.Call
import retrofit2.http.*

interface ExercicioService {

    @GET("/exercicios")
    fun getExercicios(): Call<List<ExerciciosResponseItem>>

    @POST("/exercicios")
    fun postExercicio(@Body note: ExercicioRequest): Call<ExerciciosResponseItem>

    @PUT("/exercicios/{exerciciosId}")
    fun updateExercicio(@Path("exercicio") noteId: Int, @Body note: NoteRequest): Call<ExerciciosResponseItem>

    @DELETE("/exercicios/{exerciciosId}")
    fun deleteNote(@Path("noteId") noteId: Int): Call<Void>
}