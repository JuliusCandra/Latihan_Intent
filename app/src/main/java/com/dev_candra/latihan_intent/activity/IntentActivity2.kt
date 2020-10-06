package com.dev_candra.latihan_intent.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dev_candra.latihan_intent.R
import kotlinx.android.synthetic.main.intent2_layout.*

class IntentActivity2 : AppCompatActivity(){

    private lateinit var receiveData : TextView

    companion object{
        const val NAME = "Nama"
        const val AGE = "Umur"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intent2_layout)
         receiveData  = findViewById(R.id.text1)
        val nama = intent.getStringExtra(NAME)
        val umur = intent.getIntExtra(AGE,0)
        val textReceived = "name : $nama \n Umur : $umur"
        receiveData.text = textReceived
        if (savedInstanceState != null){
            val saveData = savedInstanceState.getString("bandal")
            receiveData.text = saveData
        }
        initActionBar()
    }

    private fun initActionBar(){
        if (supportActionBar != null){
            supportActionBar!!.title = "Candra Julius Sinaga"
            supportActionBar!!.subtitle = "Intent 2"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("bandal",receiveData.text.toString())
    }

}