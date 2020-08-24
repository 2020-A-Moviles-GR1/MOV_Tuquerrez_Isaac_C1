package com.example.my_app_isaac

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent_send_parameters.*

class Intent_send_parameters : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_send_parameters)

        val numeroEncontrado : Int = intent.getIntExtra("numero", 0)

        Log.i("intents", "el numero encontrado es $numeroEncontrado")

        tv_param_recivied.text = "Parametro Recivido: $numeroEncontrado"
        //Propiedad de la clase llamada intent

        this.button_return.setOnClickListener {
            finish()
        }

        var txt_shared : String? = intent.getStringExtra(Intent.EXTRA_TEXT)

        if (txt_shared != null) {
            tv_shared.text="Texto compartido $txt_shared"
        }

        button_acpetar.setOnClickListener {
            val nombre="Hola a todos"
            val edad=31
            val intentconRespuesta = Intent()
            intentconRespuesta.putExtra("nombre", nombre)
            intentconRespuesta.putExtra("edad", edad)
            setResult(
                Activity.RESULT_OK, intentconRespuesta
            )
            finish()
        }
        button_cancel.setOnClickListener {
            val intenCancelado = Intent()
            setResult(
                Activity.RESULT_CANCELED, intenCancelado
            )
            finish()
        }


    }





}