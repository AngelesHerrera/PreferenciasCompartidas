package com.example.preferenciascompartidas

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.grabarusuario.*


class MainActivity : AppCompatActivity() {
    lateinit var txtNombre: TextView
    lateinit var edNombre: EditText
    lateinit var txtCarrera: TextView
    lateinit var edCarrera: EditText
    lateinit var txtTelefono: TextView
    lateinit var edTelefono: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtNombre = findViewById(R.id.txt_nombre)
        edNombre = findViewById(R.id.ed_nombre)
        txtCarrera = findViewById(R.id.txt_carrera)
        edCarrera = findViewById(R.id.ed_carrera)
        txtTelefono = findViewById(R.id.txt_telefono)
        edTelefono = findViewById(R.id.ed_telefono)
    }
    override fun onResume() {
        super.onResume()
        val preferencias = getSharedPreferences("mis datos", Context.MODE_PRIVATE)
        val valor = preferencias.getString("valor", "Todavia no se graba")
        val valor1 = preferencias.getString("valor1", "Todavia no se graba")
        val valor3 = preferencias.getString("valor3", "Todavia no se graba")
        txtNombre.text = valor
        txtCarrera.text = valor1
        txtTelefono.text = valor3
    }
    fun grabarValor(view: View) {
        val preferencias = getSharedPreferences("mis datos", Context.MODE_PRIVATE)
        val editor = preferencias.edit()
        val nuevoValor = edNombre.text.toString()
        val nuevoValor1 = edCarrera.text.toString()
        val nuevoValor3 = edTelefono.text.toString()
        editor.putString("valor", nuevoValor)
        editor.putString("valor1", nuevoValor1 )
        editor.putString("valor3", nuevoValor3)
        editor.commit()
        Toast.makeText(this, "se grabo", Toast.LENGTH_LONG).show()
        txtNombre.text = nuevoValor
        txtCarrera.text = nuevoValor1
        txtTelefono.text = nuevoValor3

    }

}