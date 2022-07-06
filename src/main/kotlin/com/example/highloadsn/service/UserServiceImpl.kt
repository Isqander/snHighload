package com.example.highloadsn.service

import com.example.highloadsn.dto.UserDTO
import com.example.highloadsn.model.InterestRef
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
        interests = listOf(),//TODO
        town = this.town,
        email = this.email,
        password = this.password
    )

    private fun UserDTO.toEntity() = User(
        id = this.id,
        name = this.name,
        surname = this.surname,
        age = this.age,
        sex = this.sex,
        interests = this.interests.map { InterestRef(it.id) }.toList(),
        town = this.town,
        email = this.email,
        password = this.password
    )
    override fun getAll(): List<UserDTO> = userRepository.getAll().map { it.toDTO() }

    override fun getById(id: Long): UserDTO = userRepository.findById(id)
        ?.toDTO()
        ?: throw Exception("User with id = $id not found")

    override fun create(userDto: UserDTO) : Long = userRepository.create(userDto.toEntity())

    override fun update(id: Long, userDto: UserDTO) {
        userRepository.update(id, userDto.toEntity())
    }

    override fun delete(id: Long){
        TODO("Not yet implemented")
    }
}