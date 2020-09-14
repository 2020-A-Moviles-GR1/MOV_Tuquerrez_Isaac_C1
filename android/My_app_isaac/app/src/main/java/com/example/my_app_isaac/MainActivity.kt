package com.example.my_app_isaac

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("Activity", "OnCreate")
        button_go_sa.setOnClickListener {
            go_second_activity()
        }

        button_listview.setOnClickListener {
            go_list_view()
        }

        button_go_tintent.setOnClickListener {
            go_intent()
        }

        button_implicit.setOnClickListener{
            go_intent_respuesta()
        }

        button_respuesta_propia.setOnClickListener {
            go_repsuesta_propia()
        }

        button_http.setOnClickListener {
            go_intent_http()
        }

        button_recycler.setOnClickListener {
            go_recycler()
        }

        button_map.setOnClickListener {
            go_mapa()
        }
    }

    fun go_second_activity() {
        val intentExplicito = Intent(
            this,
            Second_Activity::class.java
        )
        startActivity(intentExplicito)
    }

    fun go_list_view() {
        val intentExplicito = Intent(
            this,
            List_view_activity::class.java
        )
        startActivity(intentExplicito)
    }

    fun go_intent() {
        val intentExplicito = Intent(
            this,
            Intent_send_parameters::class.java
        )
        intentExplicito.putExtra("numero", 2)
        val adrian = Usuario(
            "ISaac",
            23,
            Date(),
            1.0
        )
        val cachetes = Mascota(
            "Manchas",
            adrian
        )
        val arregloMascotas = arrayListOf<Mascota>(cachetes)

        intentExplicito.putExtra("cachetes", cachetes)
        intentExplicito.putExtra("arregloMascotas", arregloMascotas)
        startActivity(intentExplicito)
    }

    fun go_intent_respuesta(){
        val intentconRespuesta = Intent(
            Intent.ACTION_PICK,
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        )
        startActivityForResult(intentconRespuesta, 304)
    }

    fun go_repsuesta_propia(){
        val intentconRespuesta = Intent(
            this,
            Intent_send_parameters::class.java
        )
        startActivityForResult(intentconRespuesta, 305)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.i("resultado","$resultCode")
        when (resultCode) {//resultcode
            RESULT_OK -> {
                Log.i("resultado", "OK")
                when (requestCode) { //request code -> puesto por nosotros
                    304 -> { // Contactos
                        val uri = data?.data
                        if (uri != null) {
                            val cursor = contentResolver.query(
                                uri,
                                null,
                                null,
                                null,
                                null,
                                null
                            )
                            cursor?.moveToFirst()
                            val indiceTelefono = cursor?.getColumnIndex(
                                ContactsContract.CommonDataKinds.Phone.NUMBER
                            )
                            val telefono = cursor?.getString(indiceTelefono!!)
                            cursor?.close()
                            Log.i("resultado", "Telefono: ${telefono}")
                        }
                    }
                    305 -> {
                        if (data != null) {
                            val nombre = data.getStringExtra("nombre")
                            val edad = data.getIntExtra("edad", 0)
                            Log.i("resultado", "Nombre: ${nombre} Edad: ${edad}")
                        }
                    }
                }
            }
            RESULT_CANCELED -> {
                Log.i("resultado", "=(")
            }
        }
    }

    fun go_intent_http(){
        val intentHttp = Intent(
            this,
            ActividadHttp::class.java
        )
        startActivity(intentHttp)
    }

    fun go_recycler(){
        val intentRecycler = Intent(
            this,
            Recycler::class.java
        )
        startActivity(intentRecycler)
    }

    fun go_mapa(){
        val intentHttp = Intent(
            this,
            MapsActivity::class.java
        )
        startActivity(intentHttp)
    }

}