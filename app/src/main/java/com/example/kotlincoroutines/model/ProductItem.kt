package com.example.kotlincoroutines.model

data class ProductItem(
    val limit: Int,
    val products: List<ProductX>,
    val skip: Int,
    val total: Int
)