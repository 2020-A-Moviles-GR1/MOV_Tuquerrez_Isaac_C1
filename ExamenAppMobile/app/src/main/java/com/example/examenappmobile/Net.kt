package com.example.examenappmobile

class Net{
    private val index:Int
    private val netSize:Int
    private var name:String
    private var floatData:Float
    private var doubleData:Double
    private val booleanData:Boolean
    private val nodeList: ArrayList<Node>

    constructor(index: Int, name: String, float_data: Float,
                double_data: Double, boolean_data: Boolean, net_size: Int) {
        this.index = index
        this.name = name
        this.floatData = float_data
        this.doubleData = double_data
        this.booleanData = boolean_data
        this.netSize = net_size
        this.nodeList = ArrayList<Node>()
        createNodeList()
        assignAdjList()
    }

    private fun createNodeList(){
        for (i in 0..this.netSize){
            this.nodeList.add(
                Node(index=i, name = "Node$i", floatData = i.toFloat(), doubleData = i.toDouble(),
                    booleanData = (i%2==0), adjList = ArrayList<Node>())
            )
        }
    }

    private fun assignAdjList(){
        this.nodeList.forEach{
            val allAdjList :ArrayList<Node> = ArrayList<Node>()
            for (i in 0..netSize){
                if(i != it.getIndex()){
                    allAdjList.add(this.nodeList[i])
                }
            }
            it.setArrayList(allAdjList)
        }
    }

    private fun getData(): String {
        return "$floatData, $doubleData, $booleanData tamaño: ${nodeList.size}"
    }

    override fun toString():String{
        return "$name valores: ${getData()} "
    }

    fun setNewValues(name: String, floatData: Float): Net{
        this.floatData = floatData
        this.name = name
        return this
    }

    fun getIndex():Int{
        return this.index
    }

    fun getNodeList():ArrayList<Node>{
        return this.nodeList
    }
}