package com.alu3615290.loginactivity.Adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alu3615290.loginactivity.R
import com.alu3615290.loginactivity.classes.Item
import com.alu3615290.loginactivity.databinding.ItemBinding

class ItemViewHolder(view: View):RecyclerView.ViewHolder(view) {
    val binding = ItemBinding.bind(view)
    private var likes:Boolean = true;


    fun render(itemModel:Item){
        binding.tvPokemonNombre.text = itemModel.nombrePokemon;
        binding.tipoPokemon.text = itemModel.tipoPokemon;
        binding.PokemonPeso.text = itemModel.peso.toString();
        binding.PokemonAltura.text = itemModel.altura.toString();
        binding.pbAttrPS.progress = itemModel.attr_PS;
        binding.pbAttrAtaque.progress = itemModel.attr_Ataque;
        binding.pbAttrDefensa.progress = itemModel.attr_Defensa;
        binding.pbAttrAtaqueESP.progress = itemModel.attr_Ataque_Especial;
        binding.pbAttrDefensaESP.progress = itemModel.attr_Defensa_Especial;
        binding.pbAttrVelocidad.progress = itemModel.attr_Velocidad;

        binding.MODAttrPS.text = itemModel.attr_PS.toString();
        binding.MODAttrATA.text = itemModel.attr_Ataque.toString();
        binding.MODAttrDEF.text = itemModel.attr_Defensa.toString();
        binding.MODAttrATAESP.text = itemModel.attr_Ataque_Especial.toString();
        binding.MODAttrDEFESP.text = itemModel.attr_Defensa_Especial.toString();
        binding.MODAttrVEL.text = itemModel.attr_Velocidad.toString();

        likes = itemModel.like


        colores()


        binding.fav.setOnClickListener(){
            if (likes){
                binding.fav.setImageResource(R.drawable.fav_0)
                likes = false
            }
            else {
                binding.fav.setBackgroundColor(R.drawable.fav_1)
                likes = true
            }
        }

    }

    fun colores(){
        //Bloque colores pokemon según tipo
        if (binding.tipoPokemon.text == "Psíquico"){
            binding.tipoPokemon.setBackgroundColor(R.color.pokeball)
            binding.tvPokemonNombre.setBackgroundColor(R.color.pokeball)
        }
        else if (binding.tipoPokemon.text == "Planta+Veneno"){
            binding.tipoPokemon.setBackgroundColor(R.color.green)
            binding.tvPokemonNombre.setBackgroundColor(R.color.green)
        }
        else if (binding.tipoPokemon.text == "Agua"){
            binding.tipoPokemon.setBackgroundColor(R.color.water)
            binding.tvPokemonNombre.setBackgroundColor(R.color.water)
        }
    }
}