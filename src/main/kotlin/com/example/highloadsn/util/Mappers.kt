package com.example.highloadsn.util

import com.example.highloadsn.model.Interest
import com.example.highloadsn.model.User
import org.springframework.jdbc.core.RowMapper

class Mappers {
    companion object {
        val USER_TO_DTO = RowMapper<User> { rs, _ ->
            User(
                id = rs.getLong("id"),
                name = rs.getString("name"),
                surname = rs.getString("surname"),
                age = rs.getInt("age"),
                sex = rs.getString("sex"),
//                interests = null,//TODO
                town = rs.getString("town"),
            )
        }

        val INTEREST_TO_DTO = RowMapper<Interest> { rs, _ ->
            Interest(
                id = rs.getLong("id"),
                name = rs.getString("name"),
            )
        }
    }
}