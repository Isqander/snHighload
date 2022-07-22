package com.example.highloadsn.repository

import com.example.highloadsn.model.Interest
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface InterestRepository : CrudRepository<Interest, Long> {

    fun getById(id: Long): Interest?

    fun findByName(name: String?): Interest?
}