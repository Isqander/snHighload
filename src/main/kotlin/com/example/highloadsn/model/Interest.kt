package com.example.highloadsn.model

import org.springframework.data.annotation.Id

data class Interest(
    @Id
    val id: Long,
    val name: String,
) {
//    fun addInterest(interest: InterestRef){
//        interests.add(interest)
//    }
}
