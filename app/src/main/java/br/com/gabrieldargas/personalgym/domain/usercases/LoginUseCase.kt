package br.com.gabrieldargas.personalgym.domain.usercases

import br.com.gabrieldargas.personalgym.domain.entity.RequestState
import br.com.gabrieldargas.personalgym.domain.entity.User
import br.com.gabrieldargas.personalgym.domain.entity.UserLogin
import br.com.gabrieldargas.personalgym.domain.repository.UserRepository

class LoginUseCase (
    private val userRepository: UserRepository
) {
    suspend fun doLogin(userLogin: UserLogin): RequestState<User> =
        userRepository.doLogin(userLogin)

}
