package com.example.latihanmobileapp.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
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

class elektronikPage : AppCompatActivity(), ProductAdapter.OnProductItemClickListener {

    private lateinit var recyclerView   : RecyclerView
    private lateinit var productAdapter : ProductAdapter
    private lateinit var categoryTitle  : TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elektronik)

        recyclerView                = findViewById(R.id.recyclerView)
        recyclerView.layoutManager  = GridLayoutManager(this, 2)
        categoryTitle               = findViewById(R.id.category_title)

        val category    = intent.getStringExtra("category") ?: ""
        val call        = ApiClient.apiService.getProductsByCategory(category)

        categoryTitle.text = "Hasil untuk kategori \"$category\""

        call.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    val products = response.body()
                    if (products != null) {
                        productAdapter = ProductAdapter(products, this@elektronikPage)
                        recyclerView.adapter = productAdapter
                    }
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                // Handle failure
            }
        })
    }

    override fun onProductItemClick(product: Product) {
        val intent = Intent(this, detailProdukPage::class.java)
        intent.putExtra("productId", product.id)
        intent.putExtra("productName", product.title)
        intent.putExtra("productPrice", product.price)
        intent.putExtra("productDescription", product.description)
        intent.putExtra("productImage", product.image)
        startActivity(intent)
    }
}
