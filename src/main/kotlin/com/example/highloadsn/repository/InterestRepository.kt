package com.example.highloadsn.repository

import com.example.highloadsn.model.Interest
import com.example.highloadsn.model.User
import org.springframework.stereotype.Repository

@Repository
interface InterestRepository {
    fun getAll(): List<Interest>

    fun findById(id: Long): User?

    fun create(user: User) : Long

    fun delete(id: Long)
}