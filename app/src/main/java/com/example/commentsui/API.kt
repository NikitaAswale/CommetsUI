package com.example.commentsui

import retrofit2.http.GET

interface API {
    @GET("comments")
    suspend fun getPost(): List<Post>
}