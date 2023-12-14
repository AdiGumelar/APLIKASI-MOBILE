package com.example.latihanmobileapp.Api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("products")
    fun getProducts(): Call<List<Product>>

    // Metode untuk mendapatkan produk berdasarkan kategori
    @GET("products/category/{category}")
    fun getProductsByCategory(@Path("category") category: String): Call<List<Product>>
}