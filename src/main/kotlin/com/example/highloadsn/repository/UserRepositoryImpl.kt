package com.example.highloadsn.repository

import com.example.highloadsn.model.User
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

class UserRepositoryImpl(
    private val jdbcTemplate: NamedParameterJdbcTemplate
) : UserRepository {
    override fun getAll(): List<User> {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long): User {
        TODO("Not yet implemented")
    }

    override fun create(user: User) {
        TODO("Not yet implemented")
    }

    override fun update(id: Long, user: User) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }
}