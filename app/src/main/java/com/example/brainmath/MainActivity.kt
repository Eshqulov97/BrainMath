package com.example.brainmath

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

var answer = ""
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textclock.setOnClickListener {
            Toast.makeText(this,"soat",Toast.LENGTH_SHORT).show()
        }


        btn_locked.setOnClickListener {

            if(parol_id.text.isNullOrEmpty()){
                textclock.setOnClickListener {
                    Toast.makeText(this,"soat",Toast.LENGTH_SHORT).show()
                }

            }else{

                if(parol_id.text.toString().equals(textclock.text.toString())){

                    val one = Intent(this,PlayGame::class.java)
                    startActivity(one)

                }
            }
        }


    }

}
