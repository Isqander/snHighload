package com.example.highloadsn.dto

data class UserDTO(
    val id: Long = 0,
    val name: String,
    val surname: String,
    val age: Int,
    val sex: String,
    val interests: List<InterestDTO>,
    val town: String,
)
