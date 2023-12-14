package com.example.latihanmobileapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanmobileapp.Api.ApiClient
import com.example.latihanmobileapp.Api.Product
import com.example.latihanmobileapp.Api.ProductAdapter
import com.example.latihanmobileapp.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class elektronikPage : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elektronik)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // You can replace 'electronics' with the specific category you want to retrieve
        val category = "electronics"

        val call = ApiClient.apiService.getProductsByCategory(category)

        call.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    val products = response.body()
                    if (products != null) {
                        productAdapter = ProductAdapter(products)
                        recyclerView.adapter = productAdapter
                    }
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                // Handle failure
            }
        })
    }
}
