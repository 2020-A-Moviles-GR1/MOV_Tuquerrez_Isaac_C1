package com.example.examenappmobile

import android.util.Log
import kotlin.random.Random
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.fuel.httpPut
import com.github.kittinunf.result.Result


class SailsController{

    companion object{

        private val links:ArrayList<String> = arrayListOf(
            "https://www.youtube.com/watch?v=0_0k4Dv2VL8",
            "https://www.youtube.com/watch?v=lqXrh8LITSs",
            "https://www.youtube.com/watch?v=HPzgHPMoAVs",
            "https://www.youtube.com/watch?v=FVgKy7boViQ",
            "https://www.youtube.com/watch?v=hC8CH0Z3L54",
            "https://www.youtube.com/watch?v=CoyOjv7eVLM",
            "https://www.youtube.com/watch?v=lF8sDvqZMQ8",
            "https://www.youtube.com/watch?v=AtNGid45FOI",
            "https://www.youtube.com/watch?v=9Gq9N-sPdYg",
            "https://www.youtube.com/watch?v=qU5FWU0SH0o",
            "https://www.youtube.com/watch?v=O8cgxZsAkvw",
            "https://www.youtube.com/watch?v=9jJ_ZrRXm-Y",
            "https://www.youtube.com/watch?v=a7p1R3xKSNA",
            "https://www.youtube.com/watch?v=X4Q7d0CtYyk",
            "https://www.youtube.com/watch?v=lfxXg6nNdNk",
            "https://www.youtube.com/watch?v=rqScfATfNnc",
            "https://www.youtube.com/watch?v=mYghB5Aww4A",
            "https://www.youtube.com/watch?v=lwo60B4xst0",
            "https://www.youtube.com/watch?v=XFPvw0argYA",
            "https://www.youtube.com/watch?v=Rwxfc7hWL5M",
            "https://www.youtube.com/watch?v=V_LRs_hznps",
            "https://www.youtube.com/watch?v=kuqv4Cn2VAw",
            "https://www.youtube.com/watch?v=KKqhylCi5tQ",
            "https://www.youtube.com/watch?v=Iv59IHFlZ9U",
            "https://www.youtube.com/watch?v=T8TOp-XKjck",
            "https://www.youtube.com/watch?v=bIb7w-sMNHQ",
            "https://www.youtube.com/watch?v=sVj-_rrbN2g",
            "https://www.youtube.com/watch?v=lIKbGmzVyHA",
            "https://www.youtube.com/watch?v=Ta78TWXiogk",
            "https://www.youtube.com/watch?v=f-btfcLCZVY",
            "https://www.youtube.com/watch?v=gKNJsR4EdqI",
            "https://www.youtube.com/watch?v=FWLYQk6XBxY",
            "https://www.youtube.com/watch?v=uhPVvPmVD9g",
            "https://www.youtube.com/watch?v=kiKfICu_J4g",
            "https://www.youtube.com/watch?v=dU4Ga0zkoj8",
            "https://www.youtube.com/watch?v=8vu3zrjeHUM",
            "https://www.youtube.com/watch?v=hkd94uT2Bo0",
            "https://www.youtube.com/watch?v=b_oGFcR3YNA",
            "https://www.youtube.com/watch?v=ZqKtCKc6VGs",
            "https://www.youtube.com/watch?v=KlbTXndZ5o0",
            "https://www.youtube.com/watch?v=sAsyrc0ZeS8",
            "https://www.youtube.com/watch?v=WIElO3GGLMk",
            "https://www.youtube.com/watch?v=qiDSNubgwSc",
            "https://www.youtube.com/watch?v=Wz7NaRmOYUc",
            "https://www.youtube.com/watch?v=3yRaoSn4LK4"
        )
        private val linkImgs:ArrayList<String> = arrayListOf(
            "http://192.168.100.44/MapIcons/1.png",
            "http://192.168.100.44/MapIcons/2.png",
            "http://192.168.100.44/MapIcons/3.png",
            "http://192.168.100.44/MapIcons/4.png",
            "http://192.168.100.44/MapIcons/5.png",
            "http://192.168.100.44/MapIcons/6.png",
            "http://192.168.100.44/MapIcons/7.png",
            "http://192.168.100.44/MapIcons/8.png",
            "http://192.168.100.44/MapIcons/9.png",
            "http://192.168.100.44/MapIcons/10.png",
            "http://192.168.100.44/MapIcons/11.png",
            "http://192.168.100.44/MapIcons/12.png",
            "http://192.168.100.44/MapIcons/13.png",
            "http://192.168.100.44/MapIcons/14.png",
            "http://192.168.100.44/MapIcons/15.png",
            "http://192.168.100.44/MapIcons/16.png",
            "http://192.168.100.44/MapIcons/17.png",
            "http://192.168.100.44/MapIcons/18.png",
            "http://192.168.100.44/MapIcons/19.png",
            "http://192.168.100.44/MapIcons/20.png",
            "http://192.168.100.44/MapIcons/21.png",
            "http://192.168.100.44/MapIcons/22.png",
            "http://192.168.100.44/MapIcons/23.png"
        )
        var nets:ArrayList<Net> = loadNets()
        private var count : Int = 0
        private const val mainUrl:String = "http://192.168.100.44:1337/"
        var netString : String = ""

        fun addNet(net_size: Int, link:String): Boolean {
            count ++
            var netObject :Net
            val netParameters = """{
                "index": ${count-1},
                "netSize": ${net_size},
                "name": "Net${count-1}",
                "myData": "${Random.nextLong(100000,999999)}",
                "link": "$link"
            }""".trimIndent()
            Log.i("http addNet Body", netParameters)
            val http=(mainUrl+"Net").httpPost().body(netParameters).responseString{
                    result ->
                when (result) {
                    is Result.Failure -> Log.i("http-klaxon addNet", result.getException().toString())
                    is Result.Success -> netString = result.get()
                }
            }
            http.join()
            netObject=Klaxon().parse<Net>(netString)!!
            Log.i("http-klaxon addNet fuera de http", netString)
            Log.i("http-klaxon count", "$count")
            netObject=createNodes(netObject.id, net_size)
            return this.nets.add(netObject)
        }

        fun getNet(index:Int): Net{
            return this.nets[index]
        }

        fun deleteNet(index:Int): Net {
            (mainUrl+"Net/$index").httpDelete().responseString{
                    result ->
                when(result){
                    is Result.Failure -> Log.i("http-klaxon UpdateNet", result.getException().toString())
                    is Result.Success -> Log.i("http-klaxon UpdateNet", result.get())
                }
            }
            return this.nets.removeAt(index)
        }

        fun updateNet(index:Int,net:Net){
            var myBody="""{
                "id": ${net.id},
                "name": "${net.name}",
                "myData: "${net.myData}",
                "link": "${net.link}"
                }""".trimIndent()
            Log.i("http UpdateNet body", myBody)
            (mainUrl+"Net/${net.id}").httpPut().body(myBody).responseString{
                response, request, result ->
                Log.i("http updateNet request", request.toString())
                when(result){
                    is Result.Failure -> Log.i("http UpdateNet", result.getException().toString())
                    is Result.Success -> Log.i("http UpdateNet", result.get())
                }
            }
            this.nets[index] = net
        }

        fun getList():ArrayList<Net>{
            return nets
        }

        fun loadNets(): ArrayList<Net> {
            var a : ArrayList<Net> =  arrayListOf()
            val http = (mainUrl+"Net").httpGet().responseString {
                    result ->
                when (result) {
                    is Result.Failure -> Log.i("http", result.getException().toString())
                    is Result.Success -> a = Klaxon().parseArray<Net>(result.get()) as ArrayList<Net>
                }
            }
            http.join()
            Log.i("http loadNets", a.toString())
            count = a.last().getMyIndex()+1
            Log.i("http count", "$count")
            return a

        }

        private fun getLink():String{
            return links[Random.nextInt(from=0,until=links.size-1)]
        }

        private fun getLinkImg():String{
            return linkImgs[Random.nextInt(from=0,until= linkImgs.size-1)]
        }

        private fun createNodes(netId:Int,netSize:Int):Net{
            var myBody=""
            for (i:Int in 0..netSize){
                myBody="""{
                    "index": $i,
                    "name": "Node$i",
                    "myData": "${Random.nextLong(100000, 999999)}",
                    "link": "${getLink()}",
                    "linkImg": "${getLinkImg()}",
                    "net": ${netId}
                }""".trimIndent()
                Log.i("http Node", myBody)
                (mainUrl+"Node").httpPost().body(myBody).responseString{
                    response, request, result ->
                    Log.i("http Create NodeList", request.toString())
                    when(result){
                        is Result.Failure -> Log.i("http Create NodeList", result.getException().toString())
                        is Result.Success -> Log.i("http Create NodeList", result.get())
                    }
                }
            }
            val http = (mainUrl+"Net/${netId}").httpGet().responseString{
                    result ->
                when(result){
                    is Result.Failure -> Log.i("http Create NodeList", result.getException().toString())
                    is Result.Success -> {
                        myBody=result.get()
                        Log.i("http Exact Query", myBody)
                    }
                }
            }
            http.join()
            return Klaxon().parse<Net>(myBody)!!
        }


    }
}