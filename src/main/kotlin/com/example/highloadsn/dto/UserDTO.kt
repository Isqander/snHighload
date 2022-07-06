package com.example.highloadsn.dto

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

data class UserDTO(
    val id: Long = 0,
    val name: String,
    val surname: String,
    val age: Int,
    val sex: String,
    val interests: List<InterestDTO>,
    val town: String,

    val email: String,
){
    var password: String = ""
        get() = field
        set(value){
            field = BCryptPasswordEncoder().encode(value)
        }
}
