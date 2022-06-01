package com.example.corotinexample.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    var retrofit: Retrofit? =null
    fun getRetrofitInstance(): Retrofit {
        if (retrofit==null){
            retrofit= Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())

                .build()
        }
        return retrofit!!
    }
}