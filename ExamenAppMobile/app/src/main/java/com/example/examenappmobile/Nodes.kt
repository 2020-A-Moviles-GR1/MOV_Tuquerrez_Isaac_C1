package com.example.examenappmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_nodes.*

class Nodes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nodes)

        val netIndex = intent.getIntExtra("net",0)

        textView.text = SailsController.getNet(netIndex).toString()

        val adapter: ArrayAdapter<Node> = ArrayAdapter(this,
            android.R.layout.simple_list_item_1 ,SailsController.getNet(netIndex).getNodeList())

        lstvNodes.adapter = adapter
    }
}