package com.example.ejemplorv

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejemplorv.databinding.ContactosBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val contactos = ContactosBinding.inflate(layoutInflater)
        setContentView(contactos.root)
        contactos.VistaContactos.adapter = ContactosAdapter(listOf(
            Contacto("Ale", "123456789"),
            Contacto("Angel", "987654321"),
            Contacto("David", "666666666"),
            Contacto("Ale", "123456789"),
            Contacto("Angel", "987654321"),
            Contacto("David", "666666666"),
            Contacto("Ale", "123456789"),
            Contacto("Angel", "987654321"),
            Contacto("David", "666666666"),
            Contacto("Ale", "123456789"),
            Contacto("Angel", "987654321"),
            Contacto("David", "666666666"),
            Contacto("Ale", "123456789"),
            Contacto("Angel", "987654321"),
            Contacto("David", "666666666")), object : ContactoPulsadoListener{
            override fun contactoPulsado(contacto: Contacto) {
                val dial = Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse("tel:" + contacto.tlfn)
                )
                startActivity(dial)
            }
        })
    }
}