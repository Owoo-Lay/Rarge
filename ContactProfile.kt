package com.example.contact_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contact_app.databinding.ActivityContactProfileBinding

class ContactProfile : AppCompatActivity() {
    private lateinit var binding: ActivityContactProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var bundle: Bundle? = intent.extras
        binding.name.setText(bundle?.getString("name"))
        binding.number.setText(bundle?.getString("number"))
        binding.logo.setImageResource(bundle!!.getInt("logo"))

    }
}