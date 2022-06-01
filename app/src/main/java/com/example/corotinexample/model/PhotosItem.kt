package com.example.corotinexample.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PhotosItem(
    @SerializedName("albumId")
    @Expose
    val myalbumId: Int,

    @SerializedName("id")
    @Expose
    val myId: Int,

    @SerializedName("thumbnailUrl")
    @Expose
    val myThumbnailUrl: String,

    @SerializedName("title")
    @Expose
    val myTitle: String,

    @SerializedName("url")
    @Expose
    val myUrl: String
)