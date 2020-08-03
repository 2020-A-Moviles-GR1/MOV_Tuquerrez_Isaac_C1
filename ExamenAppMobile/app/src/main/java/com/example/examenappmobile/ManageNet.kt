package com.example.examenappmobile

import android.content.Intent
import kotlinx.android.synthetic.main.activity_manage_net.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SeekBar

class ManageNet : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_net)

        txtvSizeNet.text = "Tamaño de Red: ${seekBarNetSize.progress + 1}"
        seekBarNetSize.max = 10
        seekBarNetSize.min = 1
        lstvNets.isClickable = true


        seekBarNetSize?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                // write custom code for progress is changed
                txtvSizeNet.text = "Tamaño de Red: ${seekBarNetSize.progress + 1}"
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
            }
        })

        val adapter: ArrayAdapter<Net> = ArrayAdapter(this,
            android.R.layout.simple_list_item_1 ,CompanionSaver.getList())

        lstvNets.adapter = adapter

        buttonAddNet.setOnClickListener {
            addNet(adapter)
        }

        buttonDelete.setOnClickListener {
            if (editTextNumber.text.toString().toInt() - 1 < CompanionSaver.getList()[CompanionSaver.getList().size - 1].getIndex()) {
                deleteNet(editTextNumber.text.toString().toInt() - 1 ,adapter)
            }
        }

        buttonUpdate.setOnClickListener {
            if (editTextNumber.text.toString().toInt() - 1 < CompanionSaver.getList()[CompanionSaver.getList().size - 1].getIndex()) {
                updateNet(editTextNumber.text.toString().toInt() - 1, adapter, editTextTextPersonName.text.toString(), editTextNumberDecimal.text.toString().toFloat())
            }
        }

        buttonNode.setOnClickListener {
            goNodes(editTextNumber.text.toString().toInt() - 1)
        }

    }


    private fun addNet(adapter: ArrayAdapter<Net>){
        CompanionSaver.addNet(seekBarNetSize.progress)
        adapter.notifyDataSetChanged()
    }

    private fun deleteNet(index:Int,adapter: ArrayAdapter<Net>){
        CompanionSaver.deleteNet(index)
        adapter.notifyDataSetChanged()
    }

    private fun updateNet(index:Int, adapter: ArrayAdapter<Net>, name:String, floatData:Float){
        CompanionSaver.updateNet(index,
            CompanionSaver.getNet(index).setNewValues(name,floatData)
        )
        adapter.notifyDataSetChanged()
    }

    private fun goNodes(index:Int) {
        val intentNodes = Intent(
            this,
            Nodes::class.java
        )
        intentNodes.putExtra("net", index)
        startActivity(intentNodes)
    }


}