package com.example.highloadsn.service

import com.example.highloadsn.dto.UserDTO

interface UserService {
    fun getAll(): List<UserDTO>

    fun getById(id: Long): UserDTO

    fun create(userDto: UserDTO) : Long

    fun update(id: Long, userDto: UserDTO)

    fun delete(id: Long)
}
