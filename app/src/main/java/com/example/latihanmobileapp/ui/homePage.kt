package com.example.latihanmobileapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.latihanmobileapp.R

class homePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

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
    }
}