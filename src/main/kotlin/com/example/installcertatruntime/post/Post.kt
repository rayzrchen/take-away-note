package com.example.installcertatruntime.post

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Post(
        @Id
        @GeneratedValue
        var id: UUID = UUID(0, 0),

        var author: String = "",
        var content: String = ""
)

interface PostRepository: JpaRepository<Post, UUID>


@Service
class PostService(private val postRepository: PostRepository) {

    fun create(post: Post): Post {
        return postRepository.save(post)

    }

    fun all(): MutableList<Post> {
        return postRepository.findAll()
    }

}

@RestController
@RequestMapping("api/posts")
class PostController(private val postService: PostService){

    @GetMapping
    fun all(): MutableList<Post> {
        return postService.all()
    }

    @PostMapping
    fun create(@RequestBody(required = false) post: Post): Post {
        return postService.create(post)
    }
}


