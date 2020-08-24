package com.example.my_app_isaac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_second_.*

class Second_Activity : AppCompatActivity() {
    var current_count : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_)
        Log.i("Activity", "OnCreate")

        current_count = ServicioBDDMemoria.numero
        if (current_count != 0) {
            current_value_txtvw.text = "Current Value: $current_count"
        }

        button_add.setOnClickListener {
            add_value()
        }

    }

    fun add_value(){
        this.current_count ++
        this.current_value_txtvw.text = "Current Value: $current_count"
    }

    override fun onStart() {
        super.onStart()
        Log.i("Activity", "OnStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Activity", "OnRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Activity", "OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Activity", "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Activity", "OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Activity", "OnDestroy")
    }

    override fun onSaveInstanceState(
        outState: Bundle
    ) {
        Log.i("activity", "onSaveInstanceState")
        outState?.run {
            putInt("numeroActualGuardado", current_count)
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle
    ) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("activity", "onRestoreInstanceState")
        val valorRecuperado = savedInstanceState?.getInt("numeroActualGuardado")

        if (valorRecuperado != null) {
            this.current_count = valorRecuperado
            current_value_txtvw.text = "Curren value: ${this.current_count}"
        }
    }


}