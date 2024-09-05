package com.reachrich.backtester.post.services

import com.reachrich.backtester.post.repositories.PostRepository
import com.reachrich.backtester.post.entities.Post
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostService(private val postRepository: PostRepository) {

    fun getAllPosts(): List<Post> {
        return postRepository.findAll()
    }

    fun getPostById(id: Long): Post {
        return postRepository.findById(id).orElseThrow { IllegalArgumentException("com.reachrich.backtester.post.entities.Post not found: $id") }
    }

    @Transactional
    fun createPost(post: Post): Post {
        return postRepository.save(post)
    }

    @Transactional
    fun updatePost(id: Long, updatedPost: Post): Post {
        val existingPost = getPostById(id)
        val postToSave = existingPost.copy(
            title = updatedPost.title,
            content = updatedPost.content,
            updatedAt = updatedPost.updatedAt
        )
        return postRepository.save(postToSave)
    }

    @Transactional
    fun deletePost(id: Long) {
        postRepository.deleteById(id)
    }
}
