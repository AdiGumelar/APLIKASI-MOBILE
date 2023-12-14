package com.example.latihanmobileapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
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

class homePage : AppCompatActivity(), ProductAdapter.OnProductItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var productAdapter: ProductAdapter
        val lihatSemua = findViewById<TextView>(R.id.LihatSemua)

        lihatSemua.setOnClickListener(){
            val intent = Intent(this, rekomendasiPage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out)
        }

        // Inisialisasi tombol-tombol dari navigation bar
        val btnHome : LinearLayout = findViewById(R.id.btnHome)
        val btnCart : LinearLayout = findViewById(R.id.btnCart)
        val btnProfile : LinearLayout = findViewById(R.id.btnProfile)

        // Menangani klik pada tombol Home
        btnHome.setOnClickListener {
            val intent = Intent(this, homePage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out)
        }

        // Menangani klik pada tombol Cart
        btnCart.setOnClickListener {
            val intent = Intent(this, rekomendasiPage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out)
        }

        // Menangani klik pada tombol Profile
        btnProfile.setOnClickListener {
            val intent = Intent(this, profilePage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out)
        }

        val elektronik : LinearLayout = findViewById(R.id.elektronik)

        elektronik.setOnClickListener {
            val intent = Intent(this, elektronikPage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out)
        }

        val recyclerView: RecyclerView = findViewById(R.id.main_container)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        productAdapter = ProductAdapter(emptyList(), this@homePage)
        recyclerView.adapter = productAdapter

        val call = ApiClient.apiService.getProducts()

        call.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    val products = response.body()
                    if (products != null && products.isNotEmpty()) {
                        val limitedProducts = products.take(6)
                        productAdapter = ProductAdapter(limitedProducts, this@homePage)
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