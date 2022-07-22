package com.example.highloadsn.model

import org.springframework.data.annotation.Id

class Role {
    @Id
    var id: Long? = null
    var name: String? = null

    constructor() {}
    constructor(name: String?) : super() {
        this.name = name
    }
}