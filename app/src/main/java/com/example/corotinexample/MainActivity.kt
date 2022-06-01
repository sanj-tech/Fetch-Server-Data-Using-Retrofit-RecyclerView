package com.example.corotinexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.corotinexample.adapters.PhotosAdapter
import com.example.corotinexample.api.RetrofitInstance
import com.example.corotinexample.api.RetrofitService
import com.example.corotinexample.model.PhotosItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var photoAdapters: PhotosAdapter
    lateinit var photoItem: List<PhotosItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPhotos()
    }

    private fun getPhotos() {
        val api = RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)
        val call = api.getData()
        call.enqueue(object : Callback<List<PhotosItem>?> {
            override fun onResponse(
                call: Call<List<PhotosItem>?>,
                response: Response<List<PhotosItem>?>
            ) {
                if (response.body() != null) {

                     photoItem = response.body()!!
                    photoAdapters = PhotosAdapter(applicationContext, photoItem)
                    photoRv.adapter = photoAdapters
                }
            }

            override fun onFailure(call: Call<List<PhotosItem>?>, t: Throwable) {
                Log.i("Error", t.message.toString())
            }
        })

    }
}