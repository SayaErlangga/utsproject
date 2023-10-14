package com.example.utsproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.utsproject.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySecondBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val usernameStore = intent.getStringExtra("username")
        val passwordStore = intent.getStringExtra("password")
        val emailStore = intent.getStringExtra("email")
        val tglLahirStore = intent.getStringExtra("tglLahir")
        with(binding) {
            btnLogin.setOnClickListener {
                val intentToThirdActivity = Intent(this@SecondActivity, ThirdActivity::class.java)

                val username = inputUsername.text.toString()
                val password = inputPassword.text.toString()

                if (username.isEmpty()) {
                    Toast.makeText(this@SecondActivity, "Username Belum Diisi", Toast.LENGTH_SHORT)
                        .show()
                } else if (password.isEmpty()) {
                    Toast.makeText(this@SecondActivity, "Password Belum Diisi", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    if (username != usernameStore) {
                        Toast.makeText(
                            this@SecondActivity,
                            "Username Anda Salah",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else if (password != passwordStore) {
                        Toast.makeText(
                            this@SecondActivity,
                            "Password Anda Salah",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else if (username == usernameStore && password == passwordStore) {
                        intentToThirdActivity.putExtra("email", emailStore)
                        intentToThirdActivity.putExtra("username", usernameStore)
                        intentToThirdActivity.putExtra("tglLahir", tglLahirStore)
                        startActivity(intentToThirdActivity)
                    }
                }
            }
        }
    }
}