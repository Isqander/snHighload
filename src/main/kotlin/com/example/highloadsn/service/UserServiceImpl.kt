package com.example.highloadsn.service

import com.example.highloadsn.dto.UserDTO
import com.example.highloadsn.model.User
import com.example.highloadsn.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {

    private fun User.toDTO() = UserDTO(
        id = this.id,
        name = this.name,
        surname = this.surname,
        age = this.age,
        sex = this.sex,
        interests = this.interests,
        town = this.town,
    )
    override fun getAll(): List<UserDTO> = userRepository.getAll().map { it.toDTO() }

    override fun getById(id: Long): UserDTO = userRepository.findById(id)
        ?.toDTO()
        ?: throw Exception("User wirh id = $id not found")

    override fun create(userDto: UserDTO) {
        TODO("Not yet implemented")
    }

    override fun update(id: Long, userDto: UserDTO) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long){
        TODO("Not yet implemented")
    }
}