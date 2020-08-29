package com.example.my_app_isaac

import java.util.*
import kotlin.collections.ArrayList

class UsuarioHttp(
    var id:Int,
    var createdAt: Long,
    var updatedAt: Long,
    var cedula: String,
    var nombre: String,
    var email:String,
    var estadoCivil: String,
    var password: String,
    var pokemons: ArrayList<PokemonHttp>
) {

    var fechaC: Date
    var fechaA: Date

    init{
        fechaC = Date(createdAt)
        fechaA = Date(updatedAt)
    }


}