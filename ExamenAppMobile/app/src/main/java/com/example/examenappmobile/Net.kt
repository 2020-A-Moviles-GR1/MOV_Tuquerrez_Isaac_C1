package com.example.examenappmobile

import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class Net(var id:Int,
    var createdAt:Long, var updatedAt:Long,
    val index:Int, val netSize:Int,
    var name:String, var myData :String,
    val nodes: ArrayList<Node>?=null, var link:String
){

    override fun toString():String{
        return "$index : $name My data: $myData server: {$id, ${Date(createdAt)} , ${Date(updatedAt)}} $link"
    }

    fun setNewValues(name:String, newData:String, newLink:String): Net{
        this.name=name
        this.myData=newData
        this.link=newLink
        return this
    }

    fun getMyIndex():Int{
        return this.index
    }

    fun getNodeList():ArrayList<Node>{
        return this.nodes!!
    }

}
