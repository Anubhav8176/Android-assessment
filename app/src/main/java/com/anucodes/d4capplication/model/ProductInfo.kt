package com.anucodes.d4capplication.model

import androidx.compose.ui.graphics.vector.ImageVector

data class ProductInfo(
    val productImage: Int,
    val title: String,
    val summary: String,
    val isInStock: Boolean,
    val features: String,
    val isBestSeller: Boolean,
    val isFavorite: Boolean,
    val price: Double,
    val revisedPrice: Double,
    val ratingStar: Double,
    val ratedBy: Int
)
