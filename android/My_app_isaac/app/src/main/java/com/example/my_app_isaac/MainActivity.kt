package com.example.my_app_isaac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

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
        startActivity(intentExplicito)
    }

    fun go_intent_respuesta(){
        val intentconRespuesta = Intent(
            Intent.ACTION_PICK,
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        )
        startActivityForResult(intentconRespuesta, 304)
    }



}