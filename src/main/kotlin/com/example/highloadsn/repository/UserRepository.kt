package com.example.highloadsn.repository

import com.example.highloadsn.model.User
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Long> {

    @Query("select * from user where email = :email")
    fun findByEmail(@Param("email") email: String?): User?
}