package com.reachrich.backtester.post.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Post(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val title: String,
    val content: String,

    // 작성일과 수정일을 저장
    val createdAt: String,
    val updatedAt: String?
)
