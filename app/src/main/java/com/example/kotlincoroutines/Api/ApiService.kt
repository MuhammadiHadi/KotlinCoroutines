package com.example.kotlincoroutines.Api


import com.example.kotlincoroutines.model.ProductItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/products")
    suspend fun getProduct() : Response<ProductItem>

}