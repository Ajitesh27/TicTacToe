package com.billscomconsult.tictactoelocal

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.billscomconsult.tictactoelocal.R.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    var playerOne = ArrayList<Int>()
    var playerTwo = ArrayList<Int>()
    var activePlayer =1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
    }


    protected fun btnClick(view:View){
        val btnSelected = view as Button
        var cellID=0
        when (btnSelected.id){
            id.btnOne -> cellID=1
            id.btnTwo -> cellID=2
            id.btnThree -> cellID=3
            id.btnFour -> cellID=4
            id.btnFive -> cellID=5
            id.btnSix -> cellID=6
            id.btnSeven -> cellID=7
            id.btnEight -> cellID=8
            id.btnNine -> cellID=9

        }

//        Toast.makeText(this,"ID: $cellID",Toast.LENGTH_LONG).show()

        playGame(cellID,btnSelected)

    }

    fun playGame(cellID:Int,btnSelected:Button) {

        if (activePlayer==1){
            btnSelected.text= "X"
//            btnSelected.setTextSize()
            btnSelected.setBackgroundResource(color.darkGreen)
            playerOne.add(cellID)
            activePlayer=2
            Thread.sleep(1000)
            autoPlay()
        }
        else {
            btnSelected.text= "O"
            btnSelected.setBackgroundResource(color.blue)
            playerTwo.add(cellID)
            activePlayer=1
        }

        btnSelected.isEnabled = false
        checkWinner()

    }

    fun checkWinner(){
        var winner=-1

        //ROWS
        //row 1
        if (playerOne.contains(1) && playerOne.contains(2) && playerOne.contains(3)){
            winner=1
        }
        if (playerTwo.contains(1) && playerTwo.contains(2) && playerTwo.contains(3)){
            winner=2
        }

        //row 2
        if (playerOne.contains(4) && playerOne.contains(5) && playerOne.contains(6)){
            winner=1
        }
        if (playerTwo.contains(4) && playerTwo.contains(5) && playerTwo.contains(6)){
            winner=2
        }

        //row 3
        if (playerOne.contains(7) && playerOne.contains(8) && playerOne.contains(9)){
            winner=1
        }
        if (playerTwo.contains(7) && playerTwo.contains(8) && playerTwo.contains(9)){
            winner=2
        }


        //COLUMNS
        //col 1
        if (playerOne.contains(1) && playerOne.contains(4) && playerOne.contains(7)){
            winner=1
        }
        if (playerTwo.contains(1) && playerTwo.contains(4) && playerTwo.contains(7)){
            winner=2
        }

        //col 2
        if (playerOne.contains(2) && playerOne.contains(5) && playerOne.contains(8)){
            winner=1
        }
        if (playerTwo.contains(2) && playerTwo.contains(5) && playerTwo.contains(8)){
            winner=2
        }

        //col 3
        if (playerOne.contains(3) && playerOne.contains(6) && playerOne.contains(9)){
            winner=1
        }
        if (playerTwo.contains(3) && playerTwo.contains(6) && playerTwo.contains(9)){
            winner=2
        }

        //DIAGONAL
        //diag 1
        if (playerOne.contains(1) && playerOne.contains(5) && playerOne.contains(9)){
            winner=1
        }
        if (playerTwo.contains(1) && playerTwo.contains(5) && playerTwo.contains(9)){
            winner=2
        }

        //diag 2
        if (playerOne.contains(3) && playerOne.contains(5) && playerOne.contains(7)){
            winner=1
        }
        if (playerTwo.contains(3) && playerTwo.contains(5) && playerTwo.contains(7)){
            winner=2
        }


        //Declare Winner
        if (winner != -1){

            if (winner == 1){
                Toast.makeText(this,"Player One Wins the Game",Toast.LENGTH_LONG).show()

            }else{
                Toast.makeText(this,"Player Two Wins the Game",Toast.LENGTH_LONG).show()
            }
        }
    }

    fun autoPlay(){
        var emptyCell = ArrayList<Int>()
        for (cellID in 1..9){
            if(!(playerOne.contains(cellID) || playerTwo.contains(cellID))){
                emptyCell.add(cellID)
            }
        }

        val r = Random()
        val randomIndex = r.nextInt(emptyCell.size)
        val emptyCellId = emptyCell[randomIndex]


        var selectBtn: Button?
        when (emptyCellId){
            1 -> selectBtn =btnOne
            2 -> selectBtn =btnTwo
            3 -> selectBtn =btnThree
            4 -> selectBtn =btnFour
            5 -> selectBtn =btnFive
            6 -> selectBtn =btnSix
            7 -> selectBtn =btnSeven
            8 -> selectBtn =btnEight
            9 -> selectBtn =btnNine
            else -> selectBtn=btnOne
        }

        playGame(emptyCellId,selectBtn)


    }
}
