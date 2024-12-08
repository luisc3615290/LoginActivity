package com.alu3615290.loginactivity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.core.view.isEmpty
import androidx.core.view.isNotEmpty
import androidx.core.view.size
import com.alu3615290.loginactivity.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        //básicos del binding para empezar app
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Logos de facebook y google en los botones
        val facebookButton = binding.sesionFacebook;
        val googleButton = binding.sesionGoogle;
        facebookButton.setCompoundDrawablesRelativeWithIntrinsicBounds(
            null,
            null,
            ContextCompat.getDrawable(getApplicationContext(), R.drawable.facebooklogo),
            null
        )
        googleButton.setCompoundDrawablesRelativeWithIntrinsicBounds(
            null,
            null,
            ContextCompat.getDrawable(getApplicationContext(), R.drawable.googlelogo),
            null
        )

        //Gestión de los errores y de los botones que nos llevan a navegar a sitios
        //Este inicioSesión nos llevará a RVActivity
        binding.inicioSesion.setOnClickListener() {
            binding.inicioSesion.setOnClickListener() {
                Snackbar.make(it, getString(R.string.snackbarInicioSesion), Snackbar.LENGTH_INDEFINITE)
                    .setAction(getString(R.string.snackbarAcceder)) {
                        //Vamos a RVActivity
                    }
                    .show()

            }
        }
        //Gestión de navegación a ContactActivity por parte de cualquiera de los dos botones de FB y Google
        binding.sesionFacebook.setOnClickListener() {
            Snackbar.make(it, getString(R.string.snackbarFacebook), Snackbar.LENGTH_INDEFINITE)
                .setAction(getString(R.string.snackbarAcceder)) {
                    //Vamos a ContactActivity
                }
                .show()
        }
        binding.sesionGoogle.setOnClickListener() {
            Snackbar.make(it, getString(R.string.snackbarGoogle), Snackbar.LENGTH_INDEFINITE)
                .setAction(getString(R.string.snackbarAcceder)) {
                    //Vamos a ContactActivity
                }
                .show()
        }

        //Gestión de los snackbars desde botones
        binding.hint.setOnClickListener() {
                Snackbar.make(it, getString(R.string.snackbarAyudaPassword), Snackbar.LENGTH_SHORT).show()
        }


        binding.registro.setOnClickListener() {
            Snackbar.make(it, getString(R.string.snackbarRegistro), Snackbar.LENGTH_INDEFINITE).show()
        }
        binding.paswordReset.setOnClickListener() {
            Snackbar.make(it, getString(R.string.snackbarPasswordReset), Snackbar.LENGTH_INDEFINITE).show()
        }

    }

}