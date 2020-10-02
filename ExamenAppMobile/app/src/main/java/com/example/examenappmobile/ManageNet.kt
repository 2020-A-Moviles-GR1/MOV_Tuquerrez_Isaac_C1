package com.example.examenappmobile

import android.annotation.SuppressLint
import android.content.Intent
import kotlinx.android.synthetic.main.activity_manage_net.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.SeekBar
import kotlin.reflect.typeOf


class ManageNet : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_net)
        txtvSizeNet.text = "Tamaño de Red: ${seekBarNetSize.progress + 1}"
        seekBarNetSize.max = 10
        seekBarNetSize.min = 1
        lstvNets.isClickable = true

        var txt_shared : String? = intent.getStringExtra(Intent.EXTRA_TEXT)

        if (txt_shared != null) {
            editTextTextLink.setText("$txt_shared")
        }


        seekBarNetSize?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                // write custom code for progress is changed
                txtvSizeNet.text = "Tamaño de Red: ${seekBarNetSize.progress + 1}"
            }
            override fun onStartTrackingTouch(seek: SeekBar) { }
            override fun onStopTrackingTouch(seek: SeekBar) { }
        })


        val adapter: ArrayAdapter<Net> = ArrayAdapter(this,
            android.R.layout.simple_list_item_1,SailsController.getList())

        lstvNets.adapter = adapter

        buttonAddNet.setOnClickListener {
            addNet(adapter)
            adapter.notifyDataSetChanged()

        }

        buttonDelete.setOnClickListener {
            if (editTextNumber.text.toString().toInt() - 1 < SailsController.getList()
                        [SailsController.getList().size - 1].getMyIndex()) {
                deleteNet(editTextNumber.text.toString().toInt(),adapter)
            }
        }

        buttonUpdate.setOnClickListener {
            if (editTextNumber.text.toString().toInt() - 1 < SailsController.getList()
                        [SailsController.getList().size - 1].getMyIndex()) {
                updateNet(editTextNumber.text.toString().toInt(), adapter,
                    editTextTextPersonName.text.toString(), editTextNumberDecimal.text.toString(),
                    editTextTextLink.text.toString())
            }
        }

        buttonNode.setOnClickListener {
            goNodes(editTextNumber.text.toString().toInt())
        }

    }

    private fun addNet(adapter: ArrayAdapter<Net>){
        Log.i("http netSize", "${seekBarNetSize.progress}")
        if(!SailsController.addNet(seekBarNetSize.progress, editTextTextLink.text.toString())){
            addNet(adapter)
        }

    }

    private fun deleteNet(index:Int,adapter: ArrayAdapter<Net>){
        SailsController.deleteNet(index)
        adapter.notifyDataSetChanged()
    }

    private fun updateNet(index:Int, adapter: ArrayAdapter<Net>, name:String, myData:String, link:String){
        SailsController.updateNet(index,
            SailsController.getNet(index).setNewValues(name, myData, link)
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