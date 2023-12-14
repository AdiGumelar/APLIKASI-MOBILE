package com.example.latihanmobileapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.latihanmobileapp.R

class logoutPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logout)

        val ya : Button = findViewById(R.id.yes)

        ya.setOnClickListener {
            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out)
        }

        val tidak : Button = findViewById(R.id.no)

        tidak.setOnClickListener {
            val intent = Intent(this, profilePage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out)
        }
    }
}