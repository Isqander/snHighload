package com.example.highloadsn.service

import com.example.highloadsn.dto.UserDTO
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {
    override fun getAll(): List<UserDTO>{
        TODO("Not yet implemented")
    }

    override fun getById(id: Long): UserDTO {
        TODO("Not yet implemented")
    }

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