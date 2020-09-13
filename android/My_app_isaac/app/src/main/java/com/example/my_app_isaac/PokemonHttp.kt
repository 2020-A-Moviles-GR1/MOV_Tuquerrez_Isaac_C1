package com.example.my_app_isaac

import com.beust.klaxon.Converter
import com.beust.klaxon.JsonObject
import com.beust.klaxon.JsonValue
import com.beust.klaxon.Klaxon
import java.util.*

open class PokemonHttp(
    var id: Int,
    var createdAt: kotlin.Long,
    var updatedAt: kotlin.Long,
    var nombre:String,
    var usuario:Any?
){
    var fechaC:Date
    var fechaA:Date

    init{
        fechaC = Date(createdAt)
        fechaA = Date(updatedAt)
    }

    override fun toString(): String {
        return "Nombre: $nombre, usuario: $id"
    }

    companion object {
        val conversorPokemon = object : Converter {
            override fun canConvert(cls: Class<*>) = cls == PokemonHttp::class.java

            override fun toJson(value: Any): String {
                return """
                """.trimIndent()
            }

            override fun fromJson(jsObject: JsonValue): PokemonHttp {
                val id = jsObject.objInt("id")
                val cAt = jsObject.objInt("createdAt").toLong()
                val uAt = jsObject.objInt("updatedAt").toLong()
                val nom = jsObject.objString("nombre")
                if (jsObject.obj?.get("usuario") is Int) {
                    return PokemonHttp(id, cAt, uAt, nom,
                        jsObject.objInt("usuario"))
                } else {
                    return PokemonHttp(id, cAt, uAt, nom,
                        Klaxon().parseFromJsonObject<UsuarioHttp>(jsObject.obj?.get("usuario") as JsonObject))
                }
            }
        }
    }





}