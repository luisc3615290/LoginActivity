package com.alu3615290.loginactivity.classes

class ItemProvider {
    companion object{
        val pokemonList = listOf<Item>(
            Item("Abra",
                "Psíquico",
                19.5,
                0.9,
                2,
                2,
                1,
                7,
                4,
                6,
                true,
                "R.mipmap.abra"),
            Item("Charmander",
                "Fuego",
                8.5,
                0.6,
                3,
                4,
                3,
                4,
                3,
                4,
                true,
                "R.mipmap.abra"),
            Item("Bulbasaur",
                "Planta+Veneno",
                6.9,
                0.7,
                3,
                3,
                3,
                4,
                4,
                3,
                false,
                "R.mipmap.abra"),
            Item("Squirtle",
                "Agua",
                9.0,
                0.5,
                3,
                3,
                4,
                3,
                4,
                3,
                false,
                "R.mipmap.abra"),
            Item("Sandsrew",
                "Tierra",
                12.0,
                0.6,
                3,
                5,
                5,
                2,
                2,
                3,
                false,
                "R.mipmap.abra"),
            Item("Pikachu",
                "Eléctrico",
                6.0,
                0.4,
                3,
                4,
                3,
                3,
                3,
                5,
                true,
                "R.mipmap.abra"),
            Item("Meow",
                "Normal",
                4.2,
                0.4,
                3,
                3,
                3,
                3,
                3,
                6,
                false,
                "R.mipmap.abra")
        )
    }
}