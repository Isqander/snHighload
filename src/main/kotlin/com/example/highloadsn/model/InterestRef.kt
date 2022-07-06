package com.example.highloadsn.model

import org.springframework.data.relational.core.mapping.Table

@Table("user_to_interest")
data class InterestRef(
    val interest_id: Long = 0,
)
