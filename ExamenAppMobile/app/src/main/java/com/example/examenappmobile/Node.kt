package com.example.examenappmobile

class Node {
    private var index: Int
    private var name: String
    private var floatData: Float
    private var doubleData: Double
    private var booleanData: Boolean
    private lateinit var adjList1: ArrayList<Node>

    constructor(index: Int, name: String, floatData: Float,
                doubleData: Double, booleanData: Boolean, adjList: ArrayList<Node>) {
        this.index = index
        this.name = name
        this.floatData = floatData
        this.doubleData = doubleData
        this.booleanData = booleanData
        if(adjList != null)this.adjList1 = adjList
    }



    fun setArrayList(adjList:ArrayList<Node>){
        this.adjList1 = adjList
    }

    fun getNode(index: Int) : Node{
        return this.adjList1[index]
    }

    fun getAdjList(): ArrayList<Node>{
        return this.adjList1
    }

    fun getIndex(): Int{
        return this.index
    }

    fun getName(): String{
        return this.name
    }

    private fun getData(): String {
        return "$floatData, $doubleData, $booleanData"
    }

    override fun toString():String{
        return "$name valores: ${getData()} "
    }

}