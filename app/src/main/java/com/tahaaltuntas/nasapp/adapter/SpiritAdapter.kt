package com.tahaaltuntas.nasapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tahaaltuntas.nasapp.R
import com.tahaaltuntas.nasapp.data.model.Photo

class SpiritAdapter (val photoModelListSp: ArrayList<Photo>) :
    RecyclerView.Adapter<SpiritAdapter.SpiritWH>() {
    class SpiritWH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageSp: ImageView = itemView.findViewById(R.id.img_spirit)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpiritWH {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.spirit_recycler_item, parent, false)
        return SpiritWH(view)
    }

    override fun onBindViewHolder(holder: SpiritWH, position: Int) {
        val url = photoModelListSp[position].imgSrc
        Glide.with(holder.itemView.context).load(url)
            .centerCrop()
            .into(holder.imageSp)



    }

    override fun getItemCount(): Int {
        return photoModelListSp.size
    }
}