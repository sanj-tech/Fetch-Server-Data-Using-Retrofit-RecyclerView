package com.example.corotinexample.api

import com.example.corotinexample.model.PhotosItem
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("photos")
     fun getData(): Call<List<PhotosItem>>

}