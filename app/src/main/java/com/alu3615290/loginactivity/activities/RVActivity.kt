package com.alu3615290.loginactivity.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alu3615290.loginactivity.databinding.ActivityRvPokemonsBinding

class RVActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRvPokemonsBinding

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRvPokemonsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}