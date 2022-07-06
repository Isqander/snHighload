package com.example.highloadsn.repository

import com.example.highloadsn.model.Interest
import com.example.highloadsn.model.User
import com.example.highloadsn.util.Mappers
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class InterestRepositoryImpl(
    private val jdbcTemplate: NamedParameterJdbcTemplate
) : InterestRepository {
    override fun getAll(): List<Interest> =
        jdbcTemplate.query("select * from interest order by name", Mappers.INTEREST_TO_DTO)

    override fun findById(id: Long): User? {
        TODO("Not yet implemented")
    }

    override fun create(user: User): Long {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }
}