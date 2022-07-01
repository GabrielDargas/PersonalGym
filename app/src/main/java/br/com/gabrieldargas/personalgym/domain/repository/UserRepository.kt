package br.com.gabrieldargas.personalgym.domain.repository

import br.com.gabrieldargas.personalgym.domain.entity.NewUser
import br.com.gabrieldargas.personalgym.domain.entity.RequestState
import br.com.gabrieldargas.personalgym.domain.entity.User
import br.com.gabrieldargas.personalgym.domain.entity.UserLogin

interface UserRepository {

    suspend fun getUserLogged(): RequestState<User>

    suspend fun doLogin(userLogin: UserLogin): RequestState<User>

    suspend fun resetPassword(email: String): RequestState<String>

    suspend fun create(newUser: NewUser): RequestState<User>

}