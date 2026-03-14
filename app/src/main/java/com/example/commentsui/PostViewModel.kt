package com.example.commentsui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    private val repository = Repository()

    private val _post = MutableStateFlow<List<Post>>(emptyList())
    val post: StateFlow<List<Post>> = _post

    init {
        fetchPosts()
    }

    fun fetchPosts() {
        viewModelScope.launch {
            _post.value = repository.getPost()
        }
    }
}
