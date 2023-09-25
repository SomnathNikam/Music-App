package com.example.musixsapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.annotation.RequiresApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//import java.lang.ref.Cleaner.create

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://deezerdevs-deezer.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(apiinterface::class.java)

        val retrofitdata = retrofit.getData("eminem")

        retrofitdata.enqueue(object : Callback<mydatanew> {
            override fun onResponse(
                call: Call<mydatanew?>,
                response: Response<mydatanew?>
            ) {
                // if the API call is a success then this method is executed
                val dataList= response.body()?.data
                val textView = findViewById<TextView>(R.id.Textview)
                textView.text =dataList.toString()
//                Log.d("TAG: onResponse","OnResponse: "+response.body())
            }

            override fun onFailure(call: Call<mydatanew?>, t: Throwable) {
                // if the API call is a failure then this method is executed
//                Log.d("TAG: onFailure","OnResponse: "+ t.message)
            }
        })
    }
}