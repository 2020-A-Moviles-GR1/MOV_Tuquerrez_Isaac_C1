package com.example.examenappmobile

import java.util.*
import kotlin.random.Random
import kotlin.collections.ArrayList

class Node (
    var id:Int,
    var createdAt:Long,
    var updatedAt:Long,
    val index:Int,
    var name:String,
    var myData:String,
    var net:Int,
    var link:String,
    var linkImg:String
) {

    fun getMyIndex(): Int{
        return this.index
    }

    fun getLat(minLat:Double, maxLat:Double):Double{
        return  Random.nextDouble(minLat, maxLat)
    }

    fun getLng( minLng: Double, maxLng:Double):Double{
        return Random.nextDouble(minLng, maxLng)
    }

    override fun toString():String{
        return "$index : $name : $net My data: $myData \nserver: {$id, ${Date(createdAt)} ," +
                "${Date(updatedAt)}},\nlink: $link,\nlinkImg: $linkImg"
    }


}