package br.com.gabrieldargas.personalgym.domain.usercases

import br.com.gabrieldargas.personalgym.domain.entity.RequestState
import br.com.gabrieldargas.personalgym.domain.repository.UserRepository

class ResetPasswordUseCase (
    private val userRepository: UserRepository
) {
    suspend fun resetPassword(email: String): RequestState<String> =
        userRepository.resetPassword(email)
}