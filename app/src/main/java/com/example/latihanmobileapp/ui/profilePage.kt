package com.example.latihanmobileapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.latihanmobileapp.R

class profilePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

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
    }
}