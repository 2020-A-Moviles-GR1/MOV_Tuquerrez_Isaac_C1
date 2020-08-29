package com.example.my_app_isaac

import java.util.*

class PokemonHttp (
    var id:Integer,
    var createdAt:Long,
    var updatedAt:Long,
    var nombre:String,
    var usuario:Integer
){
    var fechaC:Date
    var fechaA:Date

    init{
        fechaC = Date(createdAt)
        fechaA = Date(updatedAt)
    }
}