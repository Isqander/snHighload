package com.example.highloadsn.model

data class User(
    val id: Long = 0,
    val name: String,
    val surname: String,
    val age: Int,
    val sex: String,
    val interests: List<InterestRef> = arrayListOf(),
    val town: String,

    val email: String,
    val password: String,
    val roles: Collection<Role>,
)