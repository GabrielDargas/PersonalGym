package br.com.gabrieldargas.personalgym.domain.usercases

import br.com.gabrieldargas.personalgym.domain.entity.RequestState
import br.com.gabrieldargas.personalgym.domain.entity.User
import br.com.gabrieldargas.personalgym.domain.repository.UserRepository

class GetUserLoggedUseCase (
    private val userRepository: UserRepository
) {
    suspend fun getUserLogged(): RequestState<User> =
        userRepository.getUserLogged()
}