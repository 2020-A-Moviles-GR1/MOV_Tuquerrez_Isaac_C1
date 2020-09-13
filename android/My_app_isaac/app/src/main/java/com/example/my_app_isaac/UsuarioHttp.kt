package com.example.my_app_isaac

import com.beust.klaxon.*
import java.util.*
import kotlin.collections.ArrayList

class UsuarioHttp(
    var id: Int,
    var createdAt: Long,
    var updatedAt: Long,
    var cedula: String,
    var nombre: String,
    var email: String,
    var estadoCivil: String,
    var pokemons: ArrayList<PokemonHttp>? = null
) {

    var fechaC: Date
    var fechaA: Date

    init{
        fechaC = Date(createdAt)
        fechaA = Date(updatedAt)
    }

    override fun toString(): String {
        return "Nombre: $nombre. Cédula: $cedula"
    }

    companion object {
        val conversorUsuarioHttp = object : Converter {
            override fun canConvert(cls: Class<*>) = cls == UsuarioHttp::class.java

            override fun toJson(value: Any): String {
                return """
                    
                """.trimIndent()
            }

            override fun fromJson(jv: JsonValue): UsuarioHttp {
                return UsuarioHttp(
                    jv.objInt("id"),
                    jv.objInt("createdAt").toLong(),
                    jv.objInt("updatedAt").toLong(),
                    jv.objString("cedula"),
                    jv.objString("nombre"),
                    jv.objString("correo"),
                    jv.objString("estadoCivil"),
                    Klaxon().parseFromJsonArray<PokemonHttp>(
                        jv.obj?.get("pokemons") as JsonArray<*>
                    ) as ArrayList<PokemonHttp>
                )

            }
        }
    }

}