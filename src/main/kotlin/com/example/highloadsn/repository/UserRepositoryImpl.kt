package com.example.highloadsn.repository

import com.example.highloadsn.model.User
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val jdbcTemplate: NamedParameterJdbcTemplate
) : UserRepository {
    private companion object {
        val ROW_MAPPER = RowMapper<User> { rs, _ ->
            User(
                id = rs.getLong("id"),
                name = rs.getString("name"),
                surname = rs.getString("surname"),
                age = rs.getInt("age"),
                sex = rs.getString("sex"),
                interests = null,//TODO
                town = rs.getString("town"),
            )
        }
    }

    override fun getAll(): List<User> =
        jdbcTemplate.query("select * from user order by surname", ROW_MAPPER)


    override fun findById(id: Long): User? =
        jdbcTemplate.query(
            "select * from user where id = :id",
            mapOf("id" to id),
            ROW_MAPPER
        ).firstOrNull()

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