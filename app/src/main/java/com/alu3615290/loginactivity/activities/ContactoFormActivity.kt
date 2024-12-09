package com.alu3615290.loginactivity.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alu3615290.loginactivity.databinding.ActivityContactoFormBinding

class ContactoFormActivity : AppCompatActivity() {
    private lateinit var binding : ActivityContactoFormBinding

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactoFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}