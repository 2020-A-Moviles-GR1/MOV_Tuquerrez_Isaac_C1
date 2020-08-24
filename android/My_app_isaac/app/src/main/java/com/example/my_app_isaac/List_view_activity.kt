package com.example.my_app_isaac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list_view_activity.*

class List_view_activity : AppCompatActivity() {
    var count_trainer :Int =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_activity)


        val listaEntrenadores = arrayListOf<Entrenador>()
        for (i in 0..10){
            listaEntrenadores.add(Entrenador("Nombre$i", "Apellido$i"))
        }

        val adaptador = ArrayAdapter(
            this, // Contexto
            android.R.layout.simple_list_item_1, // Nombre Layout
            listaEntrenadores // Lista
        )

        lv_numeros.adapter = adaptador

        lv_numeros.onItemClickListener = AdapterView.OnItemClickListener {
                parent, view, position, id ->
            Log.i("list-view", "Posicion $position")
        }

        button_add_trainer.setOnClickListener {
            add_trainer(adaptador,listaEntrenadores)
            count_trainer ++
        }

    }

    fun add_trainer(
        adapter : ArrayAdapter<Entrenador>,
        lista_e : ArrayList<Entrenador>
    ){
        lista_e.add(Entrenador("AddNombre${count_trainer}", "AddApellido${count_trainer}"))
        adapter.notifyDataSetChanged()//notifica el cambio de la actividad
    }


}