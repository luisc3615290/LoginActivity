package com.alu3615290.loginactivity.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.alu3615290.loginactivity.Adapters.ItemAdapter
import com.alu3615290.loginactivity.classes.Item
import com.alu3615290.loginactivity.classes.ItemProvider
import com.alu3615290.loginactivity.databinding.ActivityRvPokemonsBinding

class RVActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRvPokemonsBinding

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRvPokemonsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()

    }
    fun initRecyclerView(){
        binding.recyclerPokemons.layoutManager = LinearLayoutManager(this)
        binding.recyclerPokemons.adapter = ItemAdapter(ItemProvider.pokemonList)
    }
}