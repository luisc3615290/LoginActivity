package com.alu3615290.loginactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.alu3615290.loginactivity.activities.ContactoFormActivity
import com.alu3615290.loginactivity.activities.RVActivity
import com.alu3615290.loginactivity.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

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
                Snackbar.make(it, getString(R.string.snackbarInicioSesion), Snackbar.LENGTH_INDEFINITE)
                    .setAction(getString(R.string.snackbarAcceder)) {
                        val intentRV = Intent(this,RVActivity::class.java)
                        startActivity(intentRV)
                    }
                    .show()
        }

        //Gestión de navegación a ContactActivity por parte de cualquiera de los dos botones de FB y Google
        facebookButton.setOnClickListener() {
            Snackbar.make(it, getString(R.string.snackbarFacebook), Snackbar.LENGTH_INDEFINITE)
                .setAction(getString(R.string.snackbarAcceder)) {
                    val intentContactos = Intent(this,ContactoFormActivity::class.java)
                    startActivity(intentContactos)
                }
                .show()
        }
        googleButton.setOnClickListener() {
            Snackbar.make(it, getString(R.string.snackbarGoogle), Snackbar.LENGTH_INDEFINITE)
                .setAction(getString(R.string.snackbarAcceder)) {
                    val intentContactos = Intent(this,ContactoFormActivity::class.java)
                    startActivity(intentContactos)
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