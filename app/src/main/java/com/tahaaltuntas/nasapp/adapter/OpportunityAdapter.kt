package com.tahaaltuntas.nasapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tahaaltuntas.nasapp.R
import com.tahaaltuntas.nasapp.data.model.Photo

class OpportunityAdapter (val photoModelListOp: ArrayList<Photo>) :
    RecyclerView.Adapter<OpportunityAdapter.OpportunityWH>() {
    class OpportunityWH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageOP: ImageView = itemView.findViewById(R.id.img_opportunity)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OpportunityWH {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.opportunity_recycler_item, parent, false)
        return OpportunityWH(view)
    }

    override fun onBindViewHolder(holder: OpportunityWH, position: Int) {
        val url = photoModelListOp[position].imgSrc
        Glide.with(holder.itemView.context).load(url)
            .centerCrop()
            .into(holder.imageOP)



    }

    override fun getItemCount(): Int {
        return photoModelListOp.size
    }
}
