package com.example.latihanmobileapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
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
    }
}