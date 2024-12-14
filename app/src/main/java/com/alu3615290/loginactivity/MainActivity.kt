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

        //función validar campos user y password
        fun validarCampos(usuario: String?, password: String?): Boolean {
            if (usuario.isNullOrBlank()) {
                println("El campo de usuario está vacío.")
                return false
            }
            if (password.isNullOrBlank()) {
                println("El campo de contraseña está vacío.")
                return false
            }
            println("Todos los campos están completos.")
            return true
        }
        //Gestión de los errores y de los botones que nos llevan a navegar a sitios
        //Este inicioSesión nos llevará a RVActivity
        //binding.txtInputUsername.toString(), binding.txtInputPassword.toString())
        binding.inicioSesion.setOnClickListener() {
            val usuario = binding.txtInputUsername
            val password = binding.txtInputPassword
            if (validarCampos(usuario.toString(), password.toString())) {
                Snackbar.make(it, getString(R.string.snackbarInicioSesion), Snackbar.LENGTH_INDEFINITE)
                    .setAction(getString(R.string.snackbarAcceder)) {
                        val intentRV = Intent(this,RVActivity::class.java)
                        startActivity(intentRV)
                    }
                    .show()
            } else {
                Snackbar.make(it, getString(R.string.camposVacios), Snackbar.LENGTH_INDEFINITE)
                    .setAction(getString(R.string.snackbarCerrar)){
                    }
                    .show()
                }
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