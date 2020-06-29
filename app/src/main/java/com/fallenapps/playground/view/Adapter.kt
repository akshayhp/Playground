package com.fallenapps.playground.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fallenapps.playground.R

class Adapter(private val items:List<ProgressViewData>):RecyclerView.Adapter<Adapter.Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context)
            .inflate(R.layout.progress_view_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(items[position])
    }

    class Holder(view:View):RecyclerView.ViewHolder(view){

        fun bind(data:ProgressViewData){
            itemView.findViewById<MyProgressView>(R.id.progressView).setAttributes(data.pColor, data.sColor, data.iColor, data.sProgress, data.iPosition)
        }
    }
}

data class ProgressViewData(val pColor:Int, val sColor:Int, val iColor:Int, val sProgress:Float, val iPosition:Float)

