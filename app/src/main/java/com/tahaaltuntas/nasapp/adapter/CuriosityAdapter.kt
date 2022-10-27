package com.tahaaltuntas.nasapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tahaaltuntas.nasapp.R
import com.tahaaltuntas.nasapp.data.model.Photo

class CuriosityAdapter(val photoModelList: ArrayList<Photo>) :
    RecyclerView.Adapter<CuriosityAdapter.CuriosityWH>() {
    class CuriosityWH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.img_curiosity)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuriosityWH {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.curiosity_recycler_item, parent, false)
        return CuriosityWH(view)
    }

    override fun onBindViewHolder(holder: CuriosityWH, position: Int) {
        val url = photoModelList[position].imgSrc
        Glide.with(holder.itemView.context).load(url)
            .centerCrop()
            .into(holder.image)



    }

    override fun getItemCount(): Int {
        return photoModelList.size
    }
}