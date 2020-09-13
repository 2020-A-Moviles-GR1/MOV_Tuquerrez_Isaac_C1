package com.example.my_app_isaac

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdaptor(
    private val listaUsuarios: List<UsuarioHttp>,
    private val contexto: Recycler,
    private val recyclerView: RecyclerView
) : RecyclerView.Adapter<RecyclerAdaptor.MyViewHolder>() {
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var nombre_tv:TextView
        var cedula_tv:TextView
        var button_tv:Button
        init {
            nombre_tv = view.findViewById(R.id.tv_nombre)
            cedula_tv = view.findViewById(R.id.tv_cedula)
            button_tv =  view.findViewById(R.id.button_accion)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):RecyclerAdaptor.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.adapatador_persona,
            parent, false)
        return MyViewHolder(itemView)
    }   

    override fun getItemCount(): Int {
        return listaUsuarios.size
    }

    //se ejecuta con cada uno de los items
    override fun onBindViewHolder(holder: MyViewHolder, //clase implementada arriba
        position: Int) { //posición
        val usuario = listaUsuarios[position]
        holder.nombre_tv.text = usuario.nombre
        holder.cedula_tv.text = usuario.cedula
        holder.button_tv.text = "Like ${usuario.nombre}"

    }
}