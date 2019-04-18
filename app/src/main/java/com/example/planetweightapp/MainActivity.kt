package com.example.planetweightapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val KILO_TO_POUND = 2.2045
    val MARS = 0.38
    val JUPITER = 2.34
    val VENUS = 0.06
    val POUND_TO_KILO = 0.4539237

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jupCheck.setOnClickListener(this)
        marsCheck.setOnClickListener(this)
        venusCheck.setOnClickListener(this)

       /* btnHesapla.setOnClickListener {
            var weightNew = userWeight.toString().toDouble()
            var pound = weightToPound(weightNew) * MARS
            var marsWeight = poundToWeight(pound)
            sncText.text = marsWeight.formats(2).toString()
        }*/


    }

    override fun onClick(v: View?) {

        v as CheckBox

        var isChecked: Boolean = v.isChecked

        if(!TextUtils.isEmpty(editText.text.toString())){

            var userWeight = editText.text.toString().toDouble()
            var pound = weightToPound(userWeight)

            when(v.id){

                R.id.marsCheck -> if(isChecked){
                    calculateWeightPound(pound,MARS)
                }
                R.id.jupCheck -> if(isChecked){
                    calculateWeightPound(pound,JUPITER)
                }
                R.id.venusCheck -> if(isChecked){
                    calculateWeightPound(pound,VENUS)
                }
            }
        }


    }

    fun calculateWeightPound(pound: Double, planets: Double){

        var sonuc = pound * planets
        var weightPound = poundToWeight(sonuc)
        sncText.text = weightPound.toString()


    }

    fun weightToPound(weight: Double) : Double {
     return  weight*KILO_TO_POUND
    }
    fun poundToWeight(pound: Double) : Double{
        return  pound*POUND_TO_KILO
    }
    fun Double.formats(which : Int) = java.lang.String.format("%.${which}f",this)
}
