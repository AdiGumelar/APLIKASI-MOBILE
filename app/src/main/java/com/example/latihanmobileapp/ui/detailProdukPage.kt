package com.example.latihanmobileapp.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.latihanmobileapp.R

class detailProdukPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_produk)

        val productId           = intent.getIntExtra("productId", 0)
        val productName         = intent.getStringExtra("productName")
        val productPrice        = intent.getDoubleExtra("productPrice", 0.0)
        val productDescription  = intent.getStringExtra("productDescription")
        val productImage        = intent.getStringExtra("productImage")

        val productNameTextView: TextView           = findViewById(R.id.productNameTextView)
        val productPriceTextView: TextView          = findViewById(R.id.productPriceTextView)
        val productDescriptionTextView: TextView    = findViewById(R.id.productDescriptionTextView)
        val productImageView: ImageView             = findViewById(R.id.productImageView)

        productNameTextView.text        = productName
        productPriceTextView.text       = "$$productPrice"
        productDescriptionTextView.text = productDescription

        Glide.with(this)
            .load(productImage)
            .into(productImageView)
    }
}