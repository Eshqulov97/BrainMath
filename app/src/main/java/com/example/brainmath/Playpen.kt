package com.example.brainmath

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_playfun.*
import java.util.*

var Natija = 0
var number = 0
var text = ""

var jami = 0
var rost = 0
var yol = 0

class Playpen : AppCompatActivity() {

    val random = Random()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playfun)

        chronoid.base = SystemClock.elapsedRealtime()
        chronoid.start()


        true_number.setText("0")
        false_number.setText("0")
         number = intent.getIntExtra("one",0)


        Ishla(number)

        Xatojavob(btn_answer1)
        Xatojavob(btn_answer2)
        Xatojavob(btn_answer3)


        when((1..3).random()){
            1->btn_answer1.setText(Natija.toString())
            2->btn_answer2.setText(Natija.toString())
            else->btn_answer3.setText(Natija.toString())
        }



    }

    fun Beginboshla(it : View){

        jami ++

        val btnpress = (it as Button).text.toString().toInt()

        if(Natija == btnpress){

            rost ++
            text = text + jami.toString() + " - true \n"
        }
        else{
            text = text + jami.toString() + " - false \n"
            yol ++
        }

        true_number.setText(rost.toString())
        false_number.setText(yol.toString())

        Ishla(number)


        Xatojavob(btn_answer1)
        Xatojavob(btn_answer2)
        Xatojavob(btn_answer3)


        val rostjoyi = (1..3).random()

        when(rostjoyi){
            1->btn_answer1.setText(Natija.toString())
            2->btn_answer2.setText(Natija.toString())
            else->btn_answer3.setText(Natija.toString())
        }

    }


    private fun Xatojavob(button: Button){

        val shart = random.nextBoolean()
        when(shart){
            true->button.setText("${Natija + (1..20).random()}")
            false->button.setText("${Natija - (1..20).random()}")
        }
    }

    private fun Ishla(son:Int){

        when(son){
            1->xisobla(1,10)
            2->xisobla(20,50)
            3->xisobla(50,100)
            4->xisobla(100,200)
            else->xisobla(100,500)
        }

    }


    private fun xisobla(bosh:Int, oxide:Int){
        var firstnum = (bosh..oxide).random()
        var scanned = (bosh..oxide).random()
        var amall = (1..4).random()

       Natija = Joyla(firstnum,scanned,amall)

        }

        fun Joyla(first:Int, second:Int, amil: Int): Int {

            var first = first
            var second = second

            var Natija1 = 0
            when(amil){
                1->{tv_answer.setText("$first + $second")}
                2->{tv_answer.setText("$first - $second")}
                3->{tv_answer.setText("$first * $second")}
                else->{tv_answer.setText("$first/$second")}
            }

           Natija1 = when(amil){
                1->{first + second}
                2->{first - second}
                3->{first * second}
                else->{first / second}
            }

            return Natija1
        }

}
