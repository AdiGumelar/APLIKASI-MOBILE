package com.example.latihanmobileapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.latihanmobileapp.R

class RegistPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regist_page)

        val textClick = findViewById<TextView>(R.id.login)
        textClick.setOnClickListener {
            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out)
        }
    }
}