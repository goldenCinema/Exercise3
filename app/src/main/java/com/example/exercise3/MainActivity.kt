package com.example.exercise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener{
            calculate()
        }
    }

    private fun clear(){
        radioGroupGender.clearCheck()
        checkBoxSmoker.isChecked=false
        textViewPremium.text=""
    }

    private fun calculate(){
        val age1=spinnerAge.selectedItemPosition
        var age = age(age1)
        var gender= male(age1)
        var smoke = smoker(age1)
        var total = age+gender+smoke
        textViewPremium.text="Total : RM "+total
    }
    private  fun age(i:Int):Int {
        when (i){
            0->return 60
            1 -> return 70
            2 -> return 90
            3 -> return 120
            else -> return 150
        }
    }
    private fun male(i:Int):Int{
        val gender = radioGroupGender
        if (gender == radioButtonMale) {
            when (i) {
                1 -> return 50
                2 -> return 100
                3 -> return 150
                else -> return 200
            }
        }else{
            return 0
        }
    }
    private fun smoker(i:Int):Int{
        if(checkBoxSmoker.isChecked){
            when(i){
                1->return 100
                2->return 150
                3->return 200
                4->return 250
                else->return 300
            }
        }else{
            return 0
        }
    }
}
