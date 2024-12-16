package com.alu3615290.loginactivity.activities

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.alu3615290.loginactivity.R
import com.alu3615290.loginactivity.databinding.ActivityContactoFormBinding
import com.google.android.material.snackbar.Snackbar

class ContactoFormActivity : AppCompatActivity() {
    private lateinit var binding : ActivityContactoFormBinding
    private val CALL_PHONE_PERMISSION_REQUEST = 123
    private val EMAIL_PERMISSION_REQUEST = 321
    private val LOCATION_PERMISSION_REQUEST = 456

        override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactoFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun hacerLlamada(phoneNumber: String){
            val intentLlamada = Intent(Intent.ACTION_CALL,Uri.parse("tel:$phoneNumber"))
            startActivity(intentLlamada)

            if (intentLlamada.resolveActivity(packageManager) != null){
                startActivity(intentLlamada)
            }
            else {
                Snackbar.make(binding.root,"No se puede CALL",Snackbar.LENGTH_INDEFINITE).show()
            }
        }

        binding.TextViewPhone.setOnClickListener(){
           if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.CALL_PHONE)
               == PackageManager.PERMISSION_GRANTED){
               hacerLlamada(getString(R.string.contact_phone))
           }
            else{
                if(ActivityCompat.shouldShowRequestPermissionRationale(this,android.Manifest.permission.CALL_PHONE)){
                    Snackbar.make(binding.root, "El permiso ha sido rechazado previamente\nDebes activarlo desde ajuses",
                    Snackbar.LENGTH_LONG).show()
               }
               else{
                   ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE),
                       CALL_PHONE_PERMISSION_REQUEST)
                }
           }
        }





        fun enviarEmail(address: String, subject: String){
            val intentEmail = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:") // Only email apps handle this.
                putExtra(Intent.EXTRA_EMAIL, address)
                putExtra(Intent.EXTRA_SUBJECT, subject)
            }
            startActivity(intentEmail)

        }

        binding.TextViewEmail.setOnClickListener(){
            if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.CALL_PHONE)
                == PackageManager.PERMISSION_GRANTED){
                enviarEmail(getString(R.string.contact_email),"Información Campamento Pokemon")
            }
            else{
                if(ActivityCompat.shouldShowRequestPermissionRationale(this,android.Manifest.permission.CALL_PHONE)){
                    Snackbar.make(binding.root, "El permiso ha sido rechazado previamente\nDebes activarlo desde ajuses",
                        Snackbar.LENGTH_LONG).show()
                }
                else{
                    ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE),
                        CALL_PHONE_PERMISSION_REQUEST)
                }
            }
        }




        fun showMap(geoLocation: Uri) {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = geoLocation
            }
            startActivity(intent)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
            else {
                Snackbar.make(binding.root,"No se puede LOCATION",Snackbar.LENGTH_INDEFINITE).show()
            }
        }

        binding.TextViewPostalAddress.setOnClickListener(){
            if ((ContextCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_COARSE_LOCATION))
                == PackageManager.PERMISSION_GRANTED){
                val postalAddress = "geo:0,0?q=Joaquín+Costa+7+,+Murcia"
                showMap(Uri.parse(postalAddress))
            }
            else {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)) {
                    Snackbar.make(
                        binding.root, "El permiso ha sido rechazado previamente\nDebes activarlo desde ajuses",
                        Snackbar.LENGTH_LONG
                    ).show()
                } else {
                    ActivityCompat.requestPermissions(
                        this, arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION), LOCATION_PERMISSION_REQUEST
                    )
                }
            }
        }

        binding.TextViewWhatsapp.setOnClickListener(){
            val intentWhatsapp = Intent(this,WhatsappActivity::class.java)
            startActivity(intentWhatsapp)
        }
    }
}