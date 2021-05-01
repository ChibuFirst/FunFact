package com.example.funfact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.funfact.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private var binding: ActivityLoginBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.buttonLogin?.setOnClickListener { validateInputs() }
    }

    private fun validateInputs() {
        val email = binding?.textInputEmail?.editText?.text.toString()
        val password = binding?.textInputPassword?.editText?.text.toString()

        if (email.isEmpty() && password.isEmpty()) {
            Toast.makeText(this, "Both fields are required.", Toast.LENGTH_LONG).show()
        } else if (email.equals("Chibuzoonuoha57@gmail.com", true) && password == "chibufirst") {
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this, "Invalid login details.", Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}