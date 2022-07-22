package com.example.highloadsn.service

import com.example.highloadsn.dto.UserDTO
import com.example.highloadsn.model.Interest
import com.example.highloadsn.model.Role
import com.example.highloadsn.model.User
import com.example.highloadsn.repository.InterestRepository
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
    private val interestRepository: InterestRepository,
) : UserService {

    private fun User.toDTO() = UserDTO(
        id = this.id,
        name = this.name,
        surname = this.surname,
        age = this.age,
        sex = this.sex,
        interests = this.getInterestIds().mapNotNull { interestRepository.getById(it)?.name }.toHashSet(),  //TODO fix N+1
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
        interests = hashSetOf(),
        town = this.town!!,
        email = this.email!!,
        password = BCryptPasswordEncoder().encode(this.password),
        roles = listOf(Role("ROLE_USER"))
    )

    override fun getAll(): List<UserDTO> = userRepository.findAll().map { it.toDTO() }

    override fun getById(id: Long): UserDTO = userRepository.findById(id).orElseThrow()
        .toDTO()

    override fun create(userDto: UserDTO) {
        userRepository.save(userDto.toEntity())
    }

    override fun update(id: Long, userDto: UserDTO) {
        userDto.id = id
        userRepository.save(userDto.toEntity())
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

    override fun addInterestToUser(userId: Long, interest: Interest) {
        val user = userRepository.findById(userId).orElseThrow()
        val interestFromDB = interestRepository.findByName(interest.name)
        if (interestFromDB != null) {
            user.addInterest(interestFromDB)
            userRepository.save(user)
        } else {
            val interest = interestRepository.save(interest)
            user.addInterest(interest)
            userRepository.save(user)
        }
    }

    private fun mapRolesToAuthorities(roles: Collection<Role>): Collection<GrantedAuthority?> {
        return roles.stream().map { role ->
            SimpleGrantedAuthority(
                role.name
            )
        }.collect(Collectors.toList())
    }
}