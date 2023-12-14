package com.example.latihanmobileapp.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.latihanmobileapp.R
import com.example.latihanmobileapp.UserData.MyApp
import com.example.latihanmobileapp.UserData.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegistPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regist_page)

        val registerButton = findViewById<Button>(R.id.registerButton)
        val namaEditText = findViewById<EditText>(R.id.namaEditText)
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)


        registerButton.setOnClickListener {
            val nama = namaEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            val userDao = MyApp.database.userDao()
            val user = User(nama = nama, email = email, password = password)

            CoroutineScope(Dispatchers.IO).launch {
                userDao.insertUser(user)
            }

            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out)
        }


        val textClick = findViewById<TextView>(R.id.login)
        textClick.setOnClickListener {
            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out)
        }

        val registLayout : LinearLayout = findViewById(R.id.registPage)

        registLayout.setOnTouchListener { _, event ->
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