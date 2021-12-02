package com.example.myapplication

import android.graphics.Color.red
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var button1 : Button
    lateinit var button2 : Button
    lateinit var button3 : Button
    lateinit var button4 : Button
    lateinit var button5 : Button
    lateinit var button6 : Button
    lateinit var button7 : Button
    lateinit var button8: Button
    lateinit var button9 : Button
    lateinit var reset : Button



    var player1 = 0
    var player2 = 1
    var activeplayer = player1
    lateinit var filledpos : intArray
    
    var gameactive = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        filledpos = intArray(-1,-1,-1,-1,-1,-1,-1,-1,-1)



        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        reset = findViewById(R.id.reset)


        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        reset.setOnClickListener(this)
    }

    private fun intArray(
        i: Int,
        i1: Int,
        i2: Int,
        i3: Int,
        i4: Int,
        i5: Int,
        i6: Int,
        i7: Int,
        i8: Int
    ) {

    }


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onClick(v: View?) {

        if (!gameactive)
            return

        var btnClicked = findViewById<Button>(v!!.id)
        var clickedTag = Integer.parseInt(btnClicked.tag.toString())

        if (filledpos[clickedTag] != -1)
            return

        filledpos[clickedTag] = activeplayer

        if(activeplayer == player1) {
            btnClicked.setText("0")
            activeplayer = player2
            btnClicked.backgroundTintList = getColorStateList(R.color.orange)
        }else{
            btnClicked.setText("x")
            activeplayer = player1
            btnClicked.backgroundTintList = getColorStateList(R.color.red)
        }

        checkForWin()
    }

    private fun checkForWin() {
        var winPos = arrayOf(intArrayOf(1,2,3),intArrayOf(4,5,6),intArrayOf(7,8,9),intArrayOf(1,4,7),intArrayOf(2,5,8),intArrayOf(3,6,9),intArrayOf(1,5,9),intArrayOf(3,5,7))

        for (i in 0 until winPos.size){
            var val1 = winPos[i][1]
            var val2 = winPos[i][2]
            var val3 = winPos[i][3]
            if (filledpos[val1] == filledpos[val2] && filledpos[val2] == filledpos[val3]){
                if (filledpos[val1] != -1 ) {
                    gameactive = false

                }
                if (filledpos[val1] == player1){
                    Toast.makeText(this, "player-1 is winner", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "player-2 is winner", Toast.LENGTH_SHORT).show()
                }

            }






        }
        var count=0
        for (i in 0 until filledpos.size) {
            if (filledpos[i] == -1) {
                count++
            }
        }
        if(count==0){

        }



    }
}