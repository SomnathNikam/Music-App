package com.example.musixsapp

import android.bluetooth.BluetoothClass.Service.AUDIO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface apiinterface {

    @Headers("X-RapidAPI-Key: 43b52aa7d6msh7b0dbc2910fb9a7p1dce43jsn61607b177b28" ,
            "X-RapidAPI-Host: deezerdevs-deezer.p.rapidapi.com")
    @GET("AUDIO")
    fun getData(@Query("q") query: String) : Call<mydatanew>
}