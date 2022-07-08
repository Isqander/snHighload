package com.example.highloadsn.repository

import com.example.highloadsn.model.User
import org.springframework.stereotype.Repository

@Repository
interface UserRepository {
    fun getAll(): List<User>

    fun findById(id: Long): User?

    fun create(user: User) : Long

    fun update(id: Long, user: User)

    fun delete(id: Long)
    fun findByEmail(username: String?): User?
}