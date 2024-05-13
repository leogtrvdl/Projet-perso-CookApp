package com.example.cookappphone.data.remote

import com.example.cookappphone.data.remote.dto.PostRequest
import com.example.cookappphone.data.remote.dto.PostResponse
import io.ktor.client.*
import io.ktor.client.request.*

class PostsServiceImpl(
    private val client: HttpClient
) : PostsService {
    override suspend fun getPosts(): List<PostResponse> {
        return client.get {
            url(HttpRoutes.GET)
        }
    }

    override suspend fun createPost(postRequest: PostRequest): PostResponse? {
        TODO("Not yet implemented")
    }
}