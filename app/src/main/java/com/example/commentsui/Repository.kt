package com.example.commentsui

class Repository {
    private val repository = RetrofitInstance.api

    suspend fun getPost(): List<Post>{
        return try {
            repository.getPost()
        }catch (e: Exception) {
            emptyList()
        }
    }
}