package com.example.highloadsn.repository

import com.example.highloadsn.model.User
import org.springframework.stereotype.Repository

@Repository
interface UserRepository {
    fun getAll(): List<User>

    fun getById(id: Long): User

    fun create(user: User)

    fun update(id: Long, user: User)

    fun delete(id: Long)
}