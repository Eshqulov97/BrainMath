package com.example.brainmath

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_playfun.*
import java.util.*


class Playpen : AppCompatActivity() {

    var Natija = 0
    var number = 0
    var jami = 0
    var rost = 0
    var yol = 0
    val random = Random()
    var text = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playfun)


        chronoid.base = SystemClock.elapsedRealtime()
        chronoid.start()

        true_number.setText("0")
        false_number.setText("0")
        number = intent.getIntExtra("one", 0)


        Ishla(number)

        Xatojavob(btn_answer1)
        Xatojavob(btn_answer2)
        Xatojavob(btn_answer3)


        when ((1..3).random()) {
            1 -> btn_answer1.setText(Natija.toString())
            2 -> btn_answer2.setText(Natija.toString())
            else -> btn_answer3.setText(Natija.toString())
        }


        btn_newgame.setOnClickListener {
            rost = 0
            yol = 0

            true_number.setText("0")
            false_number.setText("0")

            val two = Intent(this, PlayGameAll::class.java)

            startActivity(two)
            finish()
        }

        btn_allanswer.setOnClickListener {



            val aboutall = arrayOf<String>(text)
            val alertbuild = AlertDialog.Builder(this@Playpen)

            alertbuild.setTitle(" ketgan umumiy vaqt :: "+chronoid.text.toString() + " sec")
            alertbuild.setCancelable(false)

            alertbuild.setItems(aboutall) { _, which ->


            }
            alertbuild.setPositiveButton("exit") { _, _ ->
                Toast.makeText(this, "Exit", Toast.LENGTH_SHORT).show()

            }

            val malert = alertbuild.create()
            malert.show()
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
            text = text + (jami.toString() + " - false \n")
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
        var secondnum = (bosh..oxide).random()
        var amall = (1..4).random()

        when(amall){
            1->{tv_answer.setText("$firstnum + $secondnum")
                Natija = firstnum + secondnum}
            2->{tv_answer.setText("$firstnum - $secondnum")
                Natija = firstnum - secondnum}
            3->{tv_answer.setText("$firstnum * $secondnum")
                Natija = firstnum * secondnum}
            else->{
                Natija = (bosh..oxide).random()
                firstnum = Natija * secondnum
                tv_answer.setText("$firstnum/$secondnum")}
        }
    }
}
