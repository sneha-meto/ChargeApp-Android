package com.example.charge

import com.google.gson.annotations.SerializedName
import java.sql.Timestamp
import java.time.LocalDateTime

//public class ChargeModel{
//    public final int batteryLevel;
//    final Timestamp time;
//
//}
 class ChargeModel
{

    constructor(BatteryLevel : Int,Time:java.sql.Timestamp,IsCharging: Boolean){
        this.BatteryLevel=BatteryLevel
        this.Time=Time
        this.IsCharging=IsCharging
    }

    override fun toString() = "Charge($BatteryLevel, $Time, $IsCharging)"

    @SerializedName("BatteryLevel")
    var BatteryLevel :Int
    @SerializedName("Time")
    var Time:java.sql.Timestamp
    @SerializedName("IsCharging")
    var IsCharging: Boolean


}