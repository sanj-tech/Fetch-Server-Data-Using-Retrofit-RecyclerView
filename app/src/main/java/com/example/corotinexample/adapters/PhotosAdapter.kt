package com.example.corotinexample.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.corotinexample.R
import com.example.corotinexample.model.PhotosItem

class PhotosAdapter(var context: Context,var photosList: List<PhotosItem>): RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
      var view=LayoutInflater.from(context).inflate(R.layout.customlayout,parent,false)
    return PhotosViewHolder(view)

   //Question 2-how to inflate 2 custom layout

    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
     holder.id.text=photosList[position].myId.toString()
        holder.albumId.text=photosList[position].myalbumId.toString()
        holder.photoTitle.text=photosList[position].myTitle

//        Glide.with(context)
//            .load(photosList[position].myUrl)
//            //.placeholder(R.drawable.pdf)
//            .into(holder.photoUrl)

        Glide.with(context)
            .load("https://picsum.photos/200")
            .into(holder.photoImage)

//        Glide.with(this.context)
//            .load(photosList.get(position))
//            .diskCacheStrategy(DiskCacheStrategy.ALL)
//            .into(holder.photoImage)
//

//    Glide.with(context)
//            .load(photosList[position].myThumbnailUrl)
//            //.placeholder(R.drawable.pdf)
//            .into(holder.photoImage)
    }

    override fun getItemCount(): Int {
       return photosList.size
    }

    class PhotosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var id=itemView.findViewById<TextView>(R.id.txtId)
        var albumId=itemView.findViewById<TextView>(R.id.txtAlbumId)
        var photoTitle=itemView.findViewById<TextView>(R.id.txtTitle)
       // var photoUrl=itemView.findViewById<ImageView>(R.id.photourl)
        var photoImage=itemView.findViewById<ImageView>(R.id.photoimage)
        var Image=itemView.findViewById<ImageView>(R.id.custom_img)

    }

}