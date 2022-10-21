package com.example.charge


import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ChargeApi {
    @GET("/api/charge")
    suspend fun getCharges() : Response<List<ChargeModel>>

    @GET("/api/charge/cycle")
    suspend fun getChargeCycle() : Response<List<DischargeModel>>

    @GET("/api/charge/pattern")
    suspend fun getChargePattern() : Response<List<Int>>

    @POST("/api/charge")
    suspend fun postCharge(@Body charge:ChargeModel) : Response<Any>
}