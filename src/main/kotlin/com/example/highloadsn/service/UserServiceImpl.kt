package com.example.highloadsn.service

import com.example.highloadsn.dto.UserDTO
import com.example.highloadsn.model.Role
import com.example.highloadsn.model.User
import com.example.highloadsn.repository.UserRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.stream.Collectors


@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
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
        id = this.id!!,
        name = this.name!!,
        surname = this.surname!!,
        age = this.age!!,
        sex = this.sex!!,
        //    interests = this.interests!!.map { InterestRef(it.id) }.toList(),
        interests = listOf(),
        town = this.town!!,
        email = this.email!!,
        password = BCryptPasswordEncoder().encode(this.password),
        roles = listOf(Role("ROLE_USER"))
    )

    override fun getAll(): List<UserDTO> = userRepository.getAll().map { it.toDTO() }

    override fun getById(id: Long): UserDTO = userRepository.findById(id)
        ?.toDTO()
        ?: throw Exception("User with id = $id not found")

    override fun create(userDto: UserDTO): Long = userRepository.create(userDto.toEntity())

    override fun update(id: Long, userDto: UserDTO) {
        userRepository.update(id, userDto.toEntity())
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = userRepository.findByEmail(username)
            ?: throw UsernameNotFoundException("Invalid username or password.")
        return org.springframework.security.core.userdetails.User(
            user.email, user.password,
            mapRolesToAuthorities(user.roles)
        )
    }

    private fun mapRolesToAuthorities(roles: Collection<Role>): Collection<GrantedAuthority?> {
        return roles.stream().map { role ->
            SimpleGrantedAuthority(
                role.name
            )
        }.collect(Collectors.toList())
    }
}