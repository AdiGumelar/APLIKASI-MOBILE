package com.example.latihanmobileapp.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.latihanmobileapp.R

class splashScreen : AppCompatActivity() {

    private val SPLASH_TIMEOUT: Long = 2000 // Waktu tampilan splash screen (dalam milidetik)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Menggunakan Handler untuk menjalankan kode setelah SPLASH_TIMEOUT
        Handler().postDelayed({
            // Intent untuk pindah ke halaman login
            val loginIntent = Intent(this, LoginPage::class.java)
            startActivity(loginIntent)

            // Tutup aktivitas splash screen agar tidak bisa kembali ke sini
            finish()
        }, SPLASH_TIMEOUT)
    }
}
