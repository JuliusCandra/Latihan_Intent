package com.dev_candra.latihan_intent.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.dev_candra.latihan_intent.R
import kotlinx.android.synthetic.main.intent4_layout.*

class IntentActivity4 : AppCompatActivity(), View.OnClickListener{
    private lateinit var btnChooce : Button
    private lateinit var raidoGroup : RadioGroup

    companion object{
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intent4_layout)
        btnChooce = findViewById(R.id.chooseButon)
        raidoGroup = findViewById(R.id.rgNumber)
        btnChooce.setOnClickListener(this)
        actionBar()
    }

    private fun actionBar(){
        if (supportActionBar != null){
            supportActionBar!!.title = "Candra Julius Sinaga"
            supportActionBar!!.subtitle = "Intent 4"
        }
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.chooseButon){
            // Menngecek apakah radiobutton tidak kosong
            if (rgNumber.checkedRadioButtonId != 0){
                var value = 0
                // menegecek radio button mana yang dipilih
                when(rgNumber.checkedRadioButtonId){
                    R.id.rb_50 -> value = 50
                    R.id.rb_100 -> value = 100
                    R.id.rb_150 -> value = 150
                    R.id.rb_200 -> value = 200
                }
                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_SELECTED_VALUE,value)
                setResult(RESULT_CODE,resultIntent)
                finish()
            }
        }
    }
}