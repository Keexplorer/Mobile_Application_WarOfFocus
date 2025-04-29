package com.example.focusapp2.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.focusapp2.R
import com.example.focusapp2.data.entity.Basari

class BasariAdapter(private val basarilar: List<Basari>) : RecyclerView.Adapter<BasariAdapter.BasariViewHolder>() {

    class BasariViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView = itemView.findViewById(R.id.imgBasariIcon)
        val title: TextView = itemView.findViewById(R.id.txtBasariTitle)
        val desc: TextView = itemView.findViewById(R.id.txtBasariDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasariViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_basari, parent, false)
        return BasariViewHolder(view)
    }

    override fun onBindViewHolder(holder: BasariViewHolder, position: Int) {
        val basari = basarilar[position]
        holder.title.text = basari.title
        holder.desc.text = basari.description
        holder.icon.setImageResource(basari.iconResId)
    }

    override fun getItemCount(): Int = basarilar.size
}
