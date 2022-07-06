package com.example.highloadsn.repository

import com.example.highloadsn.model.User
import com.example.highloadsn.util.Mappers.Companion.USER_TO_DTO
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.stereotype.Repository
import java.math.BigInteger

@Repository
class UserRepositoryImpl(
    private val jdbcTemplate: NamedParameterJdbcTemplate
) : UserRepository {

    override fun getAll(): List<User> =
        jdbcTemplate.query("select * from user order by surname", USER_TO_DTO)


    override fun findById(id: Long): User? =
        jdbcTemplate.query(
            "select * from user where id = :id",
            mapOf("id" to id),
            USER_TO_DTO
        ).firstOrNull()

    override fun create(user: User): Long {
        val keyHolder = GeneratedKeyHolder()
        jdbcTemplate.update(
            "insert into user (name, surname, age, sex, town) values (:name, :surname, :age, :sex, :town)",
            MapSqlParameterSource( mapOf(
                "name" to user.name,
                "surname" to user.surname,
                "age" to user.age,
                "sex" to user.sex,
                "town" to user.town,
            )),
            keyHolder,
            listOf("id").toTypedArray()
        )
        return (keyHolder.keys?.getValue("GENERATED_KEY") as BigInteger).toLong()
    }

    override fun update(id: Long, user: User) {
        jdbcTemplate.update(
            "update user set name = :name, surname = :surname, age = :age, sex = :sex, town = :town where id = :id",
            mapOf(
                "id" to id,
                "name" to user.name,
                "surname" to user.surname,
                "age" to user.age,
                "sex" to user.sex,
                "town" to user.town,
            ),
        )
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }
}