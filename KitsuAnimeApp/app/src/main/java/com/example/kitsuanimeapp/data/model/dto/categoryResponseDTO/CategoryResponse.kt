package com.example.kitsuanimeapp.data.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoryResponse(
    @SerialName("data")
    val categoryData: List<Data>,
    val links: CategoryResponseLinks,
    val meta: Meta
)