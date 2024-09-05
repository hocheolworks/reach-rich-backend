package com.reachrich.backtester.post.controllers

import com.reachrich.backtester.post.entities.Post
import com.reachrich.backtester.post.services.PostService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/posts")
class PostController(private val postService: PostService) {

    @GetMapping
    fun getAllPosts(): List<Post> {
        return postService.getAllPosts()
    }

    @GetMapping("/{id}")
    fun getPostById(@PathVariable id: Long): Post {
        return postService.getPostById(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createPost(@RequestBody post: Post): Post {
        return postService.createPost(post)
    }

    @PutMapping("/{id}")
    fun updatePost(@PathVariable id: Long, @RequestBody post: Post): Post {
        return postService.updatePost(id, post)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletePost(@PathVariable id: Long) {
        postService.deletePost(id)
    }
}
