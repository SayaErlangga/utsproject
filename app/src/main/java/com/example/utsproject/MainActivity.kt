package com.example.utsproject

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.method.PasswordTransformationMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.utsproject.databinding.ActivityMainBinding
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            btnRegister.setOnClickListener{
                val intentToSecondActivity = Intent(this@MainActivity, SecondActivity::class.java)
                val email = inputEmail.text.toString()
                val username = inputUsername.text.toString()
                val password = inputPassword.text.toString()
                val year = inputThn.text.toString()
                val integerYear = year.toInt()
                val day = inputTgl.text.toString()
                val integerDay = day.toInt()
                val month = inputBulan.text.toString()
                val integerMonth = month.toInt()
                val currentYear = LocalDate.now().year

                if(email.isEmpty()){
                    Toast.makeText(this@MainActivity, "Email Belum Diisi", Toast.LENGTH_SHORT).show()
                } else if(username.isEmpty()){
                Toast.makeText(this@MainActivity, "Username Belum Diisi", Toast.LENGTH_SHORT).show()
                } else if(password.isEmpty()){
                    Toast.makeText(this@MainActivity, "Password Belum Diisi", Toast.LENGTH_SHORT).show()
                } else if(year.isEmpty()){
                    Toast.makeText(this@MainActivity, "Tahun Belum Diisi", Toast.LENGTH_SHORT).show()
                } else if(day.isEmpty()){
                    Toast.makeText(this@MainActivity, "Tanggal Belum Diisi", Toast.LENGTH_SHORT).show()
                } else if(month.isEmpty()){
                    Toast.makeText(this@MainActivity, "Bulan Belum Diisi", Toast.LENGTH_SHORT).show()
                } else {
                    if (integerDay > 31){
                        Toast.makeText(this@MainActivity, "Tanggal Tidak Relevan", Toast.LENGTH_SHORT).show()
                    } else if (integerMonth > 12){
                        Toast.makeText(this@MainActivity, "Bulan Tidak Relevan", Toast.LENGTH_SHORT).show()
                    } else {
                        if (currentYear - integerYear < 15){
                            Toast.makeText(this@MainActivity, "Anda Belum Cukup Umur", Toast.LENGTH_SHORT).show()
                        } else {
                            intentToSecondActivity.putExtra("username", username)
                            intentToSecondActivity.putExtra("password", password)
                            startActivity(intentToSecondActivity)
                        }
                    }
                }


            }
        }
    }
}