package br.com.gabrieldargas.personalgym.data.remote.mapper

import br.com.gabrieldargas.personalgym.domain.entity.NewUser
import br.com.gabrieldargas.personalgym.domain.entity.NewUserFirebasePayload
import com.google.firebase.firestore.auth.User

object NewUserFirebasePayloadMapper {
    fun mapToNewUser (newUserFirebasePayload: NewUserFirebasePayload) = NewUser(
        name = newUserFirebasePayload. name ?: "",
        email = newUserFirebasePayload. email ?: "",
        password = newUserFirebasePayload. password ?: ""
    )
    fun mapToNewUserFirebasePayload (newUser: NewUser) = NewUserFirebasePayload(
        name = newUser.name,
        email = newUser.email,
        password = newUser.password
    )
    fun mapToUser(newUserFirebasePayload: NewUserFirebasePayload ) = br.com.gabrieldargas.personalgym.domain.entity.User(
        name = newUserFirebasePayload. name ?: ""
    )
}