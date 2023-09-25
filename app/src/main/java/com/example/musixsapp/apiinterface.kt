package com.example.musixsapp

import android.bluetooth.BluetoothClass.Service.AUDIO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface apiinterface {
//
//    @Headers("" ,
//            "")
    @GET("AUDIO")
    fun getData(@Query("q") query: String) : Call<mydatanew>
}