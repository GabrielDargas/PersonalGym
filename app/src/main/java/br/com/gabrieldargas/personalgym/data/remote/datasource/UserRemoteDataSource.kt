package br.com.gabrieldargas.personalgym.data.remote.datasource

import br.com.gabrieldargas.personalgym.domain.entity.NewUser
import br.com.gabrieldargas.personalgym.domain.entity.RequestState
import br.com.gabrieldargas.personalgym.domain.entity.UserLogin
import br.com.gabrieldargas.personalgym.domain.entity.User

interface UserRemoteDataSource {

    suspend fun getUserLogged(): RequestState<User>

    suspend fun doLogin(userLogin: UserLogin): RequestState<User>

    suspend fun resetPassword(email: String): RequestState<String>

    suspend fun create(newUser: NewUser): RequestState<User>
}