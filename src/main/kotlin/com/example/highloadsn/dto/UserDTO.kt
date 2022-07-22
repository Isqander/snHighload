package com.example.highloadsn.dto

class UserDTO {

    var id: Long? = 0
    var age: Int? = 0
    var sex: String? = null
    var interests: Set<String> = HashSet()
    var town: String? = null
    var name: String? = null
    var surname: String? = null
    var email: String? = null
    var password: String? = null

    constructor() {}
    constructor(
        id: Long?,
        age: Int?,
        sex: String?,
        interests: Set<String>,
        town: String?,
        name: String?,
        surname: String?,
        email: String?,
        password: String?
    ) : super() {
        this.id = id
        this.age = age
        this.sex = sex
        this.town = town
        this.interests = interests
        this.name = name
        this.surname = surname
        this.email = email
        this.password = password
    }
}