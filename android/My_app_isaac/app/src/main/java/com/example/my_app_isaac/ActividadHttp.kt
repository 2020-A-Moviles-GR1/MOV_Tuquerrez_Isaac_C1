package com.example.my_app_isaac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpGet
import kotlinx.android.synthetic.main.activity_actividad_http.*
import kotlinx.android.synthetic.main.activity_main.*
import com.github.kittinunf.result.Result

class ActividadHttp : AppCompatActivity() {
    val urlPrincipal = "http://192.168.100.46:1337/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_http)

        button_get.setOnClickListener {
            get_users()
        }

    }

    fun get_users(){
        val pokemonString = """
            {
                "createdAt": 1597671444841,
                "updatedAt": 1597672206086,
                "id": 1,
                "nombre": "Pikachu",
                "usuario": 1
            }
            """.trimIndent()
        val pokemonInstance=Klaxon().parse<PokemonHttp>(pokemonString)
        Log.i("http-klaxon", "Nombre: ${pokemonInstance?.nombre}")
        Log.i("http-klaxon", "Creado: ${pokemonInstance?.fechaC}")
        Log.i("http-klaxon", "Actualizado: ${pokemonInstance?.fechaA}")
        val url = urlPrincipal + "Usuario"
        url.httpGet().responseString {
                request, response, result ->
            when(result){
                is Result.Success -> {
                    val data = result.get()
                    val usuarios = Klaxon().parseArray<UsuarioHttp>(data)
                    usuarios?.forEach {
                        Log.i("http-klaxon","Nombre: ${it.nombre}, ${it.estadoCivil}")
                        if(it.pokemons.size >0){
                            it.pokemons.forEach{
                                Log.i("http-klaxon","Pokemon: ${it.nombre}")

                            }
                        }
                    }
                }
                is Result.Failure -> {
                    val ex = result.getException()
                    Log.i("http-klaxon", "Error: ${ex.message}")
                }
            }
        }
    }
}