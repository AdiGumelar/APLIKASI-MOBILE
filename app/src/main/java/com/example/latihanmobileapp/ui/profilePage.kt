package com.example.latihanmobileapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.latihanmobileapp.R
import kotlin.math.log

class profilePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

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

        val profilekamu : LinearLayout = findViewById(R.id.profilkamu)
        val logout : LinearLayout = findViewById(R.id.logout)

        profilekamu.setOnClickListener {
            val intent = Intent(this, detailProfilePage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out)
        }

        logout.setOnClickListener {
            val intent = Intent(this, logoutPage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out)
        }
    }
}