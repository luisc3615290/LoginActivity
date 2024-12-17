package com.alu3615290.loginactivity.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alu3615290.loginactivity.R
import com.alu3615290.loginactivity.classes.Item

class ItemAdapter(private val pokemonList:List<Item>) :  RecyclerView.Adapter<ItemViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(layoutInflater.inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = pokemonList[position]
        holder.render(item)
    }
    override fun getItemCount(): Int {
        return pokemonList.size
    }
}