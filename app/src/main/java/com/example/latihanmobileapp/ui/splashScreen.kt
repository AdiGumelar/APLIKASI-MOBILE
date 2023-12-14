package com.example.latihanmobileapp.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.latihanmobileapp.R

class splashScreen : AppCompatActivity() {

    private val SPLASH_TIMEOUT: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            val loginIntent = Intent(this, LoginPage::class.java)
            startActivity(loginIntent)

            finish()
        }, SPLASH_TIMEOUT)
    }
}
