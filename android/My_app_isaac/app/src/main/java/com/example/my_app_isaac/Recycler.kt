package com.example.my_app_isaac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_recycler.*

class Recycler : AppCompatActivity() {
    var likes:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        val listaUsuarios:ArrayList<UsuarioHttp> = arrayListOf()

        listaUsuarios.add(
            UsuarioHttp(1, 1212423424, 213123334, "1231233432",
                "User1", "user1@user.com", "soltero", arrayListOf()
            ))
        listaUsuarios.add(
            UsuarioHttp(2, 1268788234, 213128254, "1322856291",
                "User2", "user2@user.com", "soltero", arrayListOf()
            ))
        listaUsuarios.add(
            UsuarioHttp(3, 1212564634, 213135773, "1231233432",
                "User3", "user3@user.com", "soltero", arrayListOf()
            ))
        listaUsuarios.add(
            UsuarioHttp(4, 1212567724, 2131456634, "123123343",
                "User4", "user4@user.com", "soltero", arrayListOf()
            ))
        iniciarRecyclerView(listaUsuarios,this, rv_usuarios)
    }

    private fun iniciarRecyclerView(lista: List<UsuarioHttp>, actividad: Recycler,
                                    recycler_view: androidx.recyclerview.widget.RecyclerView){
        val adaptorUsuario=RecyclerAdaptor(lista, actividad,recycler_view)
        rv_usuarios.adapter = adaptorUsuario
        rv_usuarios.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
        rv_usuarios.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(actividad)
        adaptorUsuario.notifyDataSetChanged()
    }

    fun addlikesOnactivity(numero:Int){
        this.likes += numero
        tv_titulo.text = this.likes.toString()

    }
}