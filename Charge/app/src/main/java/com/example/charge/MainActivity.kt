package com.example.charge

import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.sql.Timestamp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chargeReceiver = ChargeReceiver()
        registerReceiver(
            chargeReceiver, IntentFilter(
                Intent.ACTION_BATTERY_CHANGED
            )
        )

        calButton.setOnClickListener {
            getBatteryCycle()
            getBatteryPattern()
        }
    }


    private fun getBatteryCycle(){
        var str=""
        val chargeApi = RetrofitHelper.getInstance().create(ChargeApi::class.java)
//         launching a new coroutine
        GlobalScope.launch {
            val result = chargeApi.getChargeCycle()
            for (discharge in result.body()!!)
                str+= discharge.toString() +"\n"

            withContext(Dispatchers.Main){
                Log.d("resp::","${result.body()}")

            resTextView.text = str
        }
        Log.d("respstr::","${str}")

    }}

    private fun getBatteryPattern(){
        var str=""
        val chargeApi = RetrofitHelper.getInstance().create(ChargeApi::class.java)
//         launching a new coroutine
        GlobalScope.launch {
            val result = chargeApi.getChargePattern()

                str="Bad Count:${result.body()?.get(0)}, Optimum Count:${result.body()?.get(1)}, Spot Count:${
                    result.body()?.get(2)
                }\n "

            withContext(Dispatchers.Main){
                Log.d("resp::","${result.body()}")

                outTextView.text = str
            }
            Log.d("respstr::","${str}")

        }}
}