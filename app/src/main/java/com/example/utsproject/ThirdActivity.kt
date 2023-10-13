package com.example.utsproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.example.utsproject.databinding.ActivitySecondBinding
import com.example.utsproject.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            val clickableDashboard = findViewById<ImageView>(R.id.clickable_dashboard)
            val clickableRencana = findViewById<ImageView>(R.id.clickable_rencana)
            val clickableProfile = findViewById<ImageView>(R.id.clickable_profile)

            clickableDashboard.setOnClickListener {
                Toast.makeText(this@ThirdActivity, "Pindah Ke Dashboard", Toast.LENGTH_SHORT)
            }

            clickableProfile.setOnClickListener {
                Toast.makeText(this@ThirdActivity, "Pindah Ke Rencana", Toast.LENGTH_SHORT)
            }

            clickableRencana.setOnClickListener {
                Toast.makeText(this@ThirdActivity, "Pindah Ke Profile", Toast.LENGTH_SHORT)
            }
        }
    }
}