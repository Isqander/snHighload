package com.example.highloadsn.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.MappedCollection

data class User(
    @Id
    val id: Long = 0,
    val name: String,
    val surname: String,
    val age: Int,
    val sex: String,
    @MappedCollection(idColumn = "USER_ID")
    val interests: HashSet<InterestRef> = HashSet(),
    val town: String,

    val email: String,
    val password: String,
    val roles: Collection<Role>,
) {
    fun addInterest(interest: Interest) {
        interests.add(InterestRef(interest.id))
    }

    fun getInterestIds(): Set<Long> {
        return interests.map { it.interest_id }.toHashSet()
    }

}