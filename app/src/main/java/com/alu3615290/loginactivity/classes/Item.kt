package com.alu3615290.loginactivity.classes

import android.graphics.drawable.Drawable

data class Item (
    val nombrePokemon:String,
    val tipoPokemon:String,
    val peso:Double,
    val altura:Double,
    val attr_PS:Int,
    val attr_Ataque:Int,
    val attr_Defensa:Int,
    val attr_Ataque_Especial:Int,
    val attr_Defensa_Especial:Int,
    val attr_Velocidad:Int,
    val like:Boolean,
    val pic:String
    )