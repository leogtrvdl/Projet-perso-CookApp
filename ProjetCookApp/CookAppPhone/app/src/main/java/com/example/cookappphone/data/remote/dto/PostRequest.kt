package com.example.cookappphone.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class PostRequest(
    val recette: String,
    val ingredients: String,
    val nom: String,
    val description: String,
)