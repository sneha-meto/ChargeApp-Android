package com.example.charge

import java.time.Duration

data class DischargeModel(val Hour:Int,val Level:Int,val DischargeTime:String){
    override fun toString() = "Discharge(hr:$Hour, d-lvl:$Level, d-time: $DischargeTime)"
}
