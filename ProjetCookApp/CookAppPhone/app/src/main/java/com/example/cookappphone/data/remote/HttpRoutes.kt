package com.example.cookappphone.data.remote

object HttpRoutes {
    private const val BASE_URL = "http://localhost:8080/recettes"
    const val GET = "$BASE_URL/read"
    const val POSTS = "$BASE_URL/posts"
}