package com.alu3615290.loginactivity.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alu3615290.loginactivity.databinding.WhatsappActivityBinding

class WhatsappActivity : AppCompatActivity() {
    private lateinit var binding: WhatsappActivityBinding
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        binding = WhatsappActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener(){
            val intentBack = Intent(this,ContactoFormActivity::class.java)
            startActivity(intentBack)
        }

    }
}