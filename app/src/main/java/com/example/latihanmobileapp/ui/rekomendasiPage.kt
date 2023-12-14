package com.example.latihanmobileapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
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

class rekomendasiPage : AppCompatActivity(), ProductAdapter.OnProductItemClickListener {
    private lateinit var recyclerView   : RecyclerView
    private lateinit var productAdapter : ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rekomendasi)

        recyclerView                = findViewById(R.id.recyclerView)
        recyclerView.layoutManager  = GridLayoutManager(this, 2)
        productAdapter              = ProductAdapter(emptyList(), this@rekomendasiPage)
        recyclerView.adapter        = productAdapter

        val call = ApiClient.apiService.getProducts()

        call.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    val products = response.body()
                    if (products != null && products.isNotEmpty()) {
                        productAdapter = ProductAdapter(products, this@rekomendasiPage)
                        recyclerView.adapter = productAdapter
                    }
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                // Handle failure
            }
        })

        val btnHome     : LinearLayout = findViewById(R.id.btnHome)
        val btnCart     : LinearLayout = findViewById(R.id.btnCart)
        val btnProfile  : LinearLayout = findViewById(R.id.btnProfile)

        btnHome.setOnClickListener {
            val intent = Intent(this, homePage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out)
        }

        btnCart.setOnClickListener {
            val intent = Intent(this, rekomendasiPage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out)
        }

        btnProfile.setOnClickListener {
            val intent = Intent(this, profilePage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out)
        }
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