package com.alu3615290.loginactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.alu3615290.loginactivity.activities.ContactoFormActivity
import com.alu3615290.loginactivity.activities.RVActivity
import com.alu3615290.loginactivity.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.SplashTheme)
        //básicos del binding para empezar app
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)


        // Simular carga durante 3 segundos usando corutinas
        CoroutineScope(Dispatchers.Main).launch {
            setTheme(R.style.SplashTheme)
            delay(3000) // Pausa de 3 segundos
            // Aquí puedes cargar datos o simplemente mostrar el contenido
            setTheme(R.style.Theme_LoginActivity)
            setContentView(binding.root)
        }

        //setTheme(R.style.SplashTheme)

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
                return false
            }
            if (password.isNullOrBlank()) {
                return false
            }
            return true
        }
        fun validarCampo(string: String?): Boolean {
            if (string.isNullOrBlank()) {
                return false
            }
            return true
        }
        //Gestión de los errores y de los botones que nos llevan a navegar a sitios
        //Este inicioSesión nos llevará a RVActivity
        //binding.txtInputUsername.toString(), binding.txtInputPassword.toString())
        binding.inicioSesion.setOnClickListener() {
            val usuarioInput = binding.InputUsername?.text?.toString() ?: ""
            val passwordInput = binding.InputPassword?.text?.toString() ?: ""
            if (validarCampos(usuarioInput, passwordInput)) {
                Snackbar.make(it, getString(R.string.snackbarInicioSesion), Snackbar.LENGTH_INDEFINITE)
                    .setAction(getString(R.string.snackbarAcceder)) {
                        val intentRV = Intent(this,RVActivity::class.java)
                        startActivity(intentRV)
                    }
                    .show()
            } else if (!validarCampo(usuarioInput)) {
                binding.InputUsername?.error = getString(R.string.usuarioVacio)
            } else if (!validarCampo(passwordInput)) {
                //He tenido que usar método deprecado para ocultar el toggle (además de cambiar el xml esa propiedad "password_toggle" a app:passwordToggleEnabled="true")
                binding.txtInputPassword.isPasswordVisibilityToggleEnabled=false
                binding.InputPassword?.error = getString(R.string.passwordVacio)
                binding.txtInputPassword.errorIconDrawable
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