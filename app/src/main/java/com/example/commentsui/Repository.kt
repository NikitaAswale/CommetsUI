package com.example.commentsui

class Repository {
    private val api = RetrofitInstance.api

    suspend fun getPost(): List<Post>{
        return api.getPost()
    }
}