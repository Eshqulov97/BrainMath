package com.example.brainmath

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_play_game.*

class PlayGame : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_game)

        btn_play.setOnClickListener {

            val one = Intent(this,PlayGameAll::class.java)
            startActivity(one)

        }



        btn_exit.setOnClickListener {
            finish()
        }



    }
}
