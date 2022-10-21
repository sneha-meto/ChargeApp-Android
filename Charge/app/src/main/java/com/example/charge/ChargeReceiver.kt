package com.example.charge

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ChargeReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val batteryLevel = intent?.getIntExtra(
                BatteryManager.EXTRA_LEVEL, 0);
        val maxLevel = intent?.getIntExtra(BatteryManager.EXTRA_SCALE, 0);

        val batteryPct :Float= (batteryLevel?.toFloat()!! / maxLevel?.toFloat()!!) * 100

        val status: Int = intent?.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
        val isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING


        Log.d("sneha: ", batteryPct.toString())
        val charge = ChargeModel(batteryPct.toInt(),java.sql.Timestamp(System.currentTimeMillis()),isCharging)
        //todo: make api calls

        val chargeApi = RetrofitHelper.getInstance().create(ChargeApi::class.java)
        GlobalScope.launch {


            Log.d("charge: ", charge.toString())
            val result = chargeApi.postCharge(charge)

            Log.d("sneha: ", result.code().toString())




        }
    }
}