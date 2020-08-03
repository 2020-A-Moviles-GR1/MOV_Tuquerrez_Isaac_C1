package com.example.examenappmobile

class CompanionSaver{
    companion object{
        private val netList:ArrayList<Net> = ArrayList<Net>()
        private var count : Int = 0

        fun addNet(net_size: Int): Boolean{
            count ++
            return this.netList.add(Net(count - 1, "Net$count", count.toFloat(), count.toDouble(), count%2 == 0, net_size))
        }

        fun getNet(index:Int): Net{
            return this.netList[index]
        }

        fun deleteNet(index:Int): Net {
           return this.netList.removeAt(index)
        }

        fun getList(): ArrayList<Net>{
            return this.netList
        }

        fun updateNet(index:Int,net:Net){
            netList[index] = net
        }


    }
}