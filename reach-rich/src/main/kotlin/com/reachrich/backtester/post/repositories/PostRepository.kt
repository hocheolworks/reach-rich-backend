package com.reachrich.backtester.post.repositories

import com.reachrich.backtester.post.entities.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long>
