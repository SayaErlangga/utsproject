package com.example.utsproject

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import com.example.utsproject.databinding.ActivityFourthBinding
import com.example.utsproject.databinding.ActivitySecondBinding

class FourthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val stasiun = arrayOf(
            "Yogyakarta - St.Lempuyangan",
            "Solo - St.Balapan",
            "Semarang - St.Semarang Tawang",
            "Jakarta - St.Manggarai"
        )

        val hargaStasiun = arrayOf(
            10,
            20,
            40,
            70
        )
        val kelas = arrayOf(
            "Ekonomi",
            "Bisnis",
            "Eksekutif",
            "Premium"
        )

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

        val hargaKelas = arrayOf(
            20,
            30,
            40,
            50
        )

        var hargaStasiun1 = 0
        var hargaStasiun2 = 0
        var hargaKelasDummy = 0
        var hargaTiket = 0
        var stasiun1 = ""
        var stasiun2 = ""
        var kelasKereta = ""
        var selectedDate = ""
        var makanSiang = "Tidak"
        var sewaPorter = "Tidak"
        var taksi = "Tidak"
        var bagasi = "Tidak"
        var dudukSendiri = "Tidak"
        var dudukDepan = "Tidak"
        var extraSnack = "Tidak"
        with(binding){

            datePicker.init(
                datePicker.year,
                datePicker.month,
                datePicker.dayOfMonth
            ) {_, year, month, dayOfMonth ->
                selectedDate = "$dayOfMonth ${bulan.get(month)} $year"
            }

            val intentToThirdActivity = Intent(this@FourthActivity, ThirdActivity::class.java)

            val adapterStasiun = ArrayAdapter<String>(this@FourthActivity, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, stasiun)
            spinnerAsal.adapter = adapterStasiun
            spinnerTujuan.adapter = adapterStasiun

            val adapterKelas = ArrayAdapter<String>(this@FourthActivity, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, kelas)
            spinnerClass.adapter = adapterKelas

            val priceTextView: TextView = findViewById(R.id.txt_harga)
            val toggleSwitch1: Switch = findViewById(R.id.switch1)
            val toggleSwitch2: Switch = findViewById(R.id.switch2)
            val toggleSwitch3: Switch = findViewById(R.id.switch3)
            val toggleSwitch4: Switch = findViewById(R.id.switch4)
            val toggleSwitch5: Switch = findViewById(R.id.switch5)
            val toggleSwitch6: Switch = findViewById(R.id.switch6)
            val toggleSwitch7: Switch = findViewById(R.id.switch7)

            spinnerAsal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    val selectedPrice = hargaStasiun[position] * 1000
                    stasiun1 = stasiun[position]
                    hargaStasiun1 = selectedPrice
                    if (stasiun1 == stasiun2){
                        hargaTiket = 0
                    } else {
                        hargaTiket = hargaStasiun1 + hargaStasiun2 + hargaKelasDummy
                    }
                    priceTextView.text = "Harga: $hargaTiket"  // Tampilkan harga yang dipilih
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    // Implementasikan jika diperlukan
                }
            }

            spinnerTujuan.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    val selectedPrice = hargaStasiun[position] * 1000
                    stasiun2 = stasiun[position]
                    hargaStasiun2 = selectedPrice
                    if (stasiun1 == stasiun2){
                        hargaTiket = 0
                    } else {
                        hargaTiket = hargaStasiun1 + hargaStasiun2 + hargaKelasDummy
                    }
                    priceTextView.text = "Harga: $hargaTiket"
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    // Implementasikan jika diperlukan
                }
            }

            spinnerClass.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    val selectedPrice = hargaKelas[position] * 1000
                    kelasKereta = kelas[position]
                    hargaKelasDummy = selectedPrice
                    if (stasiun1 == stasiun2){
                        hargaTiket = 0
                    } else {
                        hargaTiket = hargaStasiun1 + hargaStasiun2 + hargaKelasDummy
                    }
                    priceTextView.text = "Harga: $hargaTiket"  // Tampilkan harga yang dipilih
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    // Implementasikan jika diperlukan
                }
            }

            toggleSwitch1.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    hargaTiket += 30000
                    makanSiang = "Ya"
                } else {
                    hargaTiket -= 30000
                    makanSiang = "Tidak"
                }
                priceTextView.text = "Harga: $hargaTiket"
            }
            toggleSwitch2.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    hargaTiket += 20000
                    sewaPorter = "Ya"
                } else {
                    hargaTiket -= 20000
                    sewaPorter = "Tidak"
                }
                priceTextView.text = "Harga: $hargaTiket"
            }
            toggleSwitch3.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    hargaTiket += 50000
                    taksi = "Ya"
                } else {
                    hargaTiket -= 50000
                    taksi = "Tidak"
                }
                priceTextView.text = "Harga: $hargaTiket"
            }
            toggleSwitch4.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    hargaTiket += 20000
                    bagasi = "Ya"
                } else {
                    hargaTiket -= 20000
                    bagasi = "Tidak"
                }
                priceTextView.text = "Harga: $hargaTiket"
            }
            toggleSwitch5.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    hargaTiket += 150000
                    dudukSendiri = "Ya"
                } else {
                    hargaTiket -= 150000
                    dudukSendiri = "Tidak"
                }
                priceTextView.text = "Harga: $hargaTiket"
            }
            toggleSwitch6.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    hargaTiket += 20000
                    dudukDepan = "Ya"
                } else {
                    hargaTiket -= 20000
                    dudukDepan = "Tidak"
                }
                priceTextView.text = "Harga: $hargaTiket"
            }
            toggleSwitch7.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    hargaTiket += 15000
                    extraSnack = "Ya"
                } else {
                    hargaTiket -= 15000
                    extraSnack = "Tidak"
                }
                priceTextView.text = "Harga: $hargaTiket"
            }
            val clickableDashboard = findViewById<ImageView>(R.id.clickable_dashboard)

            clickableDashboard.setOnClickListener {
                startActivity(intentToThirdActivity)
            }



            btnSimpan.setOnClickListener {
                val intent = Intent()
                intent.putExtra("stAsal", stasiun1)
                intent.putExtra("stTujuan", stasiun2)
                intent.putExtra("kelasKereta", kelasKereta)
                intent.putExtra("tglBerangkat", selectedDate)
                intent.putExtra("makanSiang", makanSiang)
                intent.putExtra("sewaPorter", sewaPorter)
                intent.putExtra("taksi", taksi)
                intent.putExtra("bagasi", bagasi)
                intent.putExtra("dudukSendiri", dudukSendiri)
                intent.putExtra("dudukDepan", dudukDepan)
                intent.putExtra("extraSnack", extraSnack)
                setResult(RESULT_OK, intent)
                finish()
            }

            val clickableProfile = findViewById<ImageView>(R.id.clickable_profile)

            clickableProfile.setOnClickListener {
                val intentToThirdActivity = Intent(this@FourthActivity, FiveActivity::class.java)

                startActivity(intentToThirdActivity)
            }
        }
    }
}