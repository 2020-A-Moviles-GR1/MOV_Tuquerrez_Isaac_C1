package com.example.examenappmobile

import kotlin.random.Random

class Node (
    var id:Int,
    var createdAt:Long,
    var updatedAt:Long,
    val index:Int,
    var name:String,
    var myData:String,
    var net:Int,
    var link:String
) {



    fun getMyIndex(): Int{
        return this.index
    }

    override fun toString():String{
        return "$index : $name : $net My data: $myData server: {$id, $createdAt , $updatedAt}, link: $link"
    }

}