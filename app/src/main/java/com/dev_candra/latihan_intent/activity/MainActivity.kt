package com.dev_candra.latihan_intent.activity

import android.app.Person
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.dev_candra.latihan_intent.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.intent3_layout.*


class MainActivity : AppCompatActivity(),View.OnClickListener{
        private lateinit var button1 : Button
        private lateinit var button2 : Button
        private lateinit var button3 : Button
        private lateinit var button4 : Button
        private lateinit var text1 : TextView
        private lateinit var button5 : Button

    companion object{
        private const val REQUEST_CODE = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initWidget()
        if (savedInstanceState != null){
            val saveData = savedInstanceState.getString("bandit")
            text1.text = saveData
        }
    }

    private fun initWidget(){
        button1 = findViewById(R.id.button1)
        button1.setOnClickListener(this)
        button2 = findViewById(R.id.button2)
        button2.setOnClickListener(this)
        button3 = findViewById(R.id.button3)
        button3.setOnClickListener(this)
        button4 = findViewById(R.id.button4)
        button4.setOnClickListener(this)
        text1 = findViewById(R.id.hasilTeks1)
        button5 = findViewById(R.id.button5)
        button5.setOnClickListener(this)
        actionBar()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button1 -> {
                startActivity(Intent(this@MainActivity, IntentActivity1::class.java))

            }
            R.id.button2 -> {
                val intentMoveData = Intent(this@MainActivity, IntentActivity2::class.java)
                intentMoveData.putExtra(IntentActivity2.NAME, "Candra Julius Sinaga")
                intentMoveData.putExtra(IntentActivity2.AGE, 21)
                startActivity(intentMoveData)
            }
            R.id.button3 -> {
              val inisiasiPerson = com.dev_candra.latihan_intent.activity.entity.Person(
                  "Candra Julius Sinaga",
                  21,
                  "Jl HM Said No 63 Medan",
                  "Medan"
              )
               val intent = Intent(this@MainActivity,IntentActivity3::class.java)
                intent.putExtra(IntentActivity3.EXTRA_PERSON,inisiasiPerson)
                startActivity(intent)
            }
            R.id.button4 -> {
                val numberDeveloper = "082311558341"
                val dialNumber = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$numberDeveloper"))
                startActivity(dialNumber)
            }
            R.id.button5 -> {
                val intent = Intent(this@MainActivity,IntentActivity4::class.java)
                startActivityForResult(intent, REQUEST_CODE)
            }
        }
    }

    private fun actionBar(){
        if (supportActionBar != null){
            supportActionBar!!.title = "Candra Julius Sinaga"
            supportActionBar!!.subtitle = "Latihan Intent"
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE){
            if (resultCode == IntentActivity4.RESULT_CODE){
                val selectedValue = data?.getIntExtra(IntentActivity4.EXTRA_SELECTED_VALUE,0)
                text1.text = "Hasil $selectedValue"
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("bandit",text1.text.toString())
    }

}