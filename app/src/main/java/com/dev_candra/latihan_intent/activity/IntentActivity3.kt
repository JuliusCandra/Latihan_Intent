package com.dev_candra.latihan_intent.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dev_candra.latihan_intent.R
import com.dev_candra.latihan_intent.activity.entity.Person


class IntentActivity3 : AppCompatActivity() {


    companion object {
        const val EXTRA_PERSON = "extra_person"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intent3_layout)
        val text1 : TextView = findViewById(R.id.teks1)
        val person = intent.getParcelableExtra(EXTRA_PERSON) as Person
        val textReceived = "Nama : ${person.nama} \n Umur : ${person.umur} \n Alamat : ${person.alamat} \n Kota : ${person.kota}"
        text1.text = textReceived
        // method ini bisa menggantikan person = Person
//    var person = ArrayList<com.dev_candra.latihan_intent.activity.entity.Person>()
//    mendapatkan data dari arrayList person
//       val  person  = intent.getParcelableArrayListExtra(EXTRA_PERSON) as ArrayList<com.dev_candra.latihan_intent.activity.entity.Person>
    }
    private fun initActionBar(){
        if (supportActionBar != null){
            supportActionBar!!.title = "Candra Julius Sinaga"
            supportActionBar!!.subtitle = "Intent 3"
        }
    }
}