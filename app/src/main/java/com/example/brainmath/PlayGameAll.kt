package com.example.brainmath

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.AlertDialog
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_play_game_all.*



class PlayGameAll : AppCompatActivity() {

    lateinit var btn_alert: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_game_all)

        btn_alert = findViewById(R.id.id_aboutlevel)

        playgame.setOnClickListener {

            if(level_1.isChecked){

                val one = Intent(this,Playpen::class.java)
                one.putExtra("one",1)
                startActivity(one)
            }

            if(level_2.isChecked){

                val one = Intent(this,Playpen::class.java)
                one.putExtra("one",2)
                startActivity(one)
            }
            if(level_3.isChecked){

                val one = Intent(this,Playpen::class.java)
                one.putExtra("one",3)
                startActivity(one)
            }
            if(level_4.isChecked){

                val one = Intent(this,Playpen::class.java)
                one.putExtra("one",4)
                startActivity(one)
            }

            if(level_5.isChecked){

                val one = Intent(this,Playpen::class.java)
                one.putExtra("one",5)
                startActivity(one)
            }

        }

        val aboutall = arrayOf("1 chi 1 dan 10 gacha son oralig'ida ","2 chi 20 - 50 gacha son oralig'ida","3 chi 50 dan 100 gacha son oralig'ida","4 chi 100 dan 200 gacha son oralig'ida","5 chi 100 dan 500 gacha son oralig'ida")

        btn_alert.setOnClickListener {

            val alertbuild = AlertDialog.Builder(this@PlayGameAll)

            alertbuild.setTitle("This is Title about level")
            alertbuild.setCancelable(false)

            alertbuild.setItems(aboutall){_,which->


            }
            alertbuild.setPositiveButton("exit"){_,_->
                Toast.makeText(this,"Exit",Toast.LENGTH_SHORT).show()
            }

            val malert = alertbuild.create()
            malert.show()

        }

    }
}
