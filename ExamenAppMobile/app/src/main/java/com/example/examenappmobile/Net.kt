package com.example.examenappmobile

import kotlin.random.Random

class Net(
    var id:Int,
    var createdAt:Long,
    var updatedAt:Long,
    val index:Int,
    val netSize:Int,
    var name:String,
    var myData :String,
    val nodes: ArrayList<Node>?=null
){




    override fun toString():String{
        return "$index : $name My data: $myData server: {$id, $createdAt , $updatedAt}"
    }

    fun setNewValues(name:String, newData:String): Net{
        this.name=name
        this.myData=newData
        return this
    }

    fun getMyIndex():Int{
        return this.index
        //return this.id
    }

    fun getNodeList():ArrayList<Node>{
        return this.nodes!!
        //return arrayListOf()
    }

}
