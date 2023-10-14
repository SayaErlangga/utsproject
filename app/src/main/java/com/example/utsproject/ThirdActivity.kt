package com.example.utsproject

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.utsproject.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        if(result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            val stAsal = data?.getStringExtra("stAsal")
            val stTujuan = data?.getStringExtra("stTujuan")
            val kelas = data?.getStringExtra("kelasKereta")
            val tglBerangkat = data?.getStringExtra("tglBerangkat")
            val makanSiang = data?.getStringExtra("makanSiang")
            val sewaPorter = data?.getStringExtra("sewaPorter")
            val taksi = data?.getStringExtra("taksi")
            val bagasi = data?.getStringExtra("bagasi")
            val dudukSendiri = data?.getStringExtra("dudukSendiri")
            val dudukDepan = data?.getStringExtra("dudukDepan")
            val extraSnack = data?.getStringExtra("extraSnack")

            binding.layoutData.visibility = View.VISIBLE
            binding.altData.visibility = View.INVISIBLE
            binding.stAsal.text = stAsal
            binding.stTujuan.text = stTujuan
            binding.kelas.text = kelas
            binding.tglBerangkat.text = tglBerangkat
            binding.makanSiang.text = makanSiang
            binding.sewaPorter.text = sewaPorter
            binding.taksi.text = taksi
            binding.bagasi.text = bagasi
            binding.dudukSendiri.text = dudukSendiri
            binding.dudukDepan.text = dudukDepan
            binding.extraSnack.text = extraSnack


        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val usernameStore = intent.getStringExtra("username")
        val emailStore = intent.getStringExtra("email")
        val tglLahirStore = intent.getStringExtra("tglLahir")

        with(binding){
            val clickableRencana = findViewById<ImageView>(R.id.clickable_rencana)
            val clickableProfile = findViewById<ImageView>(R.id.clickable_profile)
            val bulan = arrayOf(
                "Januari",
                "Februari",
                "Maret",
                "April",
                "Mei",
                "Juni",
                "Juli",
                "Agustus",
                "September",
                "Oktober",
                "November",
                "Desember"
            )
            var selectedDate = ""
            datePicker.init(
                datePicker.year,
                datePicker.month,
                datePicker.dayOfMonth
            ) { view, year, month, dayOfMonth ->
                selectedDate = "$dayOfMonth ${bulan.get(month)} $year"
                if(selectedDate == tglBerangkat.text.toString()){
                    Toast.makeText(this@ThirdActivity, "Ada Rencana Perjalanan", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@ThirdActivity, "Tidak Ada Rencana Perjalanan", Toast.LENGTH_SHORT).show()
                }
            }

            clickableRencana.setOnClickListener {
                val intent = Intent(this@ThirdActivity, FourthActivity::class.java).apply {

                }
                launcher.launch(intent)
            }

            clickableProfile.setOnClickListener {
                val intentToFiveActivity = Intent(this@ThirdActivity, FiveActivity::class.java)
                intentToFiveActivity.putExtra("email", emailStore)
                intentToFiveActivity.putExtra("username", usernameStore)
                intentToFiveActivity.putExtra("tglLahir", tglLahirStore)
                startActivity(intentToFiveActivity)
            }
        }
    }
}