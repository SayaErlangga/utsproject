package com.example.utsproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.utsproject.databinding.ActivityFiveBinding

class FiveActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFiveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFiveBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val usernameStore = intent.getStringExtra("username")
        val emailStore = intent.getStringExtra("email")
        val tglLahirStore = intent.getStringExtra("tglLahir")

        with(binding){
            email.text = emailStore
            username.text = usernameStore
            tglLahir.text = tglLahirStore

            val clickableDashboard = findViewById<ImageView>(R.id.clickable_dashboard)
            val clickableRencana = findViewById<ImageView>(R.id.clickable_rencana)

            clickableDashboard.setOnClickListener {
                val intentToThirdActivity = Intent(this@FiveActivity, ThirdActivity::class.java)

                startActivity(intentToThirdActivity)
            }

            clickableRencana.setOnClickListener {
                val intentToFourthActivity = Intent(this@FiveActivity, FourthActivity::class.java)

                startActivity(intentToFourthActivity)
            }
        }
    }
}