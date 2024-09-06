package com.reachrich.backtester.post.services

import com.reachrich.backtester.post.repositories.PostRepository
import com.reachrich.backtester.post.entities.Post
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostService(private val postRepository: PostRepository) {

    fun findAllPosts(): List<Post> {
        return postRepository.findAll()
    }

    fun findPostById(id: Long): Post {
        return postRepository.findById(id).orElseThrow { IllegalArgumentException("com.reachrich.backtester.post.entities.Post not found: $id") }
    }

    @Transactional
    fun generatePost(post: Post): Post {
        return postRepository.save(post)
    }

    @Transactional
    fun modifyPost(id: Long, updatedPost: Post): Post {
        val existingPost = findPostById(id)
        val postToSave = existingPost.copy(
            title = updatedPost.title,
            content = updatedPost.content,
            updatedAt = updatedPost.updatedAt
        )

        return postRepository.save(postToSave)
    }

    @Transactional
    fun removePost(id: Long) {
        postRepository.deleteById(id)
    }
}
