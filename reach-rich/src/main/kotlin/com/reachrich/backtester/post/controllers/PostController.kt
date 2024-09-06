package com.reachrich.backtester.post.controllers

import com.reachrich.backtester.post.entities.Post
import com.reachrich.backtester.post.services.PostService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/posts")
class PostController(private val postService: PostService) {

    @Operation(summary = "게시글 목록 조회", description = "모든 게시글의 목록을 조회합니다.")
    @GetMapping
    fun findAllPosts(): List<Post> {
        return postService.findAllPosts()
    }


    @Operation(summary = "게시글 단건 조회", description = "ID로 특정 게시글을 조회합니다.")
    @GetMapping("/{id}")
    fun getPostById(@PathVariable id: Long): Post {
        return postService.findPostById(id)
    }

    @Operation(summary = "게시글 작성", description = "새로운 게시글을 작성합니다.")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createPost(@RequestBody post: Post): Post {
        return postService.generatePost(post)
    }

    @PutMapping("/{id}")
    fun updatePost(@PathVariable id: Long, @RequestBody post: Post): Post {
        return postService.modifyPost(id, post)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletePost(@PathVariable id: Long) {
        postService.removePost(id)
    }
}
