package br.com.gabrieldargas.personalgym.domain.usercases

import br.com.gabrieldargas.personalgym.domain.entity.NewUser
import br.com.gabrieldargas.personalgym.domain.entity.RequestState
import br.com.gabrieldargas.personalgym.domain.entity.User
import br.com.gabrieldargas.personalgym.domain.repository.UserRepository

class CreateUserUseCase (
    private val userRepository: UserRepository
) {
    suspend fun create(newUser: NewUser): RequestState<User> =
        userRepository.create(newUser)
}