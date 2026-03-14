package com.example.commentsui

import retrofit2.http.GET

interface API {
    @GET("posts/1")
    suspend fun getPost(): List<Post>
}