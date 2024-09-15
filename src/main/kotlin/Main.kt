package ru.netology

fun main () {
    val likes = Likes (100)
    WallService.add(Post(0, "Kotlin is cool", can_pin = true, can_delete = false, can_edit = true, post_type = "copy", 1, is_favorite = true, likes))
    WallService.add(Post(0, "I love my wife", can_pin = true, can_delete = false, can_edit = false, post_type = "post", 1, is_favorite = true, likes))
    println(WallService.update(Post(2, "Kotlin is not difficult", can_pin = true, can_delete = false, can_edit = false, post_type = "post", is_pinned = 1, is_favorite = true, likes)))
    WallService.printPosts()
}

data class Post ( val id: Int = 0, val Text: String, val can_pin: Boolean, val can_delete: Boolean, val can_edit: Boolean, val post_type: String, val is_pinned: Int, val is_favorite: Boolean, val likes: Likes = Likes())
data class Likes (val count: Int = 0)

object WallService {

    private var posts = emptyArray<Post>()
    private var lastId = 0

    fun add(post: Post): Boolean {
        posts += post.copy(id = ++lastId)
        return true
    }

    fun update(newPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (posts[index].id == newPost.id) {
                posts[index] = newPost.copy(likes = post.likes.copy())
                return true
            }
        }
        return false
    }
    fun printPosts() {
        for (post in posts) {
            print (post)
            println(" ")
        }
        println()
    }

        fun clear() {
            posts = emptyArray()
            lastId = 0
        }
    }
