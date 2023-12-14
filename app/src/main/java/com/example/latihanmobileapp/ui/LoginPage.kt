package com.example.latihanmobileapp.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.latihanmobileapp.R
import com.example.latihanmobileapp.UserData.MyApp

class LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)


        val loginButton = findViewById<Button>(R.id.loginButton)
        val namaEditText = findViewById<TextView>(R.id.username)
        val passwordEditText = findViewById<TextView>(R.id.password)
        val userDao = MyApp.database.userDao()

        loginButton.setOnClickListener {
            val username = namaEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Memeriksa apakah pengguna dengan username yang sesuai ada di database
            userDao.getUserByUsername(username).observe(this, { user ->
                if (user != null && user.password == password) {
                    // Login berhasil, lanjutkan ke halaman utama atau halaman lain
                    val intent = Intent(this, homePage::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out)
                } else {
                    // Login gagal, tampilkan pesan kesalahan atau tindakan lain
                    Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show()
                }
            })
        }

        val textClick = findViewById<TextView>(R.id.regiser)
        textClick.setOnClickListener {
            val intent = Intent(this, RegistPage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out)
        }

        val loginLayout : LinearLayout = findViewById(R.id.loginPage)

        loginLayout.setOnTouchListener { _, event ->
            // Sembunyikan keyboard ketika pengguna menyentuh area di luar elemen input
            hideKeyboard()
            return@setOnTouchListener false
        }

    }
    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }
}