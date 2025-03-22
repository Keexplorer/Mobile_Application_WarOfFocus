package com.example.profilepageforwof.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.profilepageforwof.Domain.ContentDomain
import com.example.profilepageforwof.R
import com.google.android.material.imageview.ShapeableImageView

class ContentAdapter(private var contentList: List<ContentDomain>) :
    RecyclerView.Adapter<ContentAdapter.ContentViewHolder>() {

    inner class ContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.contentText)
        val shapeableImageView: ShapeableImageView = itemView.findViewById(R.id.picContent)
        val imageView: ImageView=itemView.findViewById(R.id.contentArrow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_content, parent, false)
        return ContentViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {

        val content = contentList[position]
        holder.textView.text= content.Title

        // İçeriğe göre uygun resmi ata
        val imageRes = when (content.Title) {
            "5 Boss kestin" -> R.drawable.swords
            "10 gündür giriş yapıyorsun" -> R.drawable.run
            "25. Levele ulaştın" -> R.drawable.yirmibes
            "Örnek" -> R.drawable.ozan
            else -> R.drawable.ozan // Varsayılan resim
        }


        holder.shapeableImageView.setImageResource(imageRes)


    }

    override fun getItemCount() = contentList.size

    fun updateContent(newContent: List<ContentDomain>) {
        contentList = newContent
        notifyDataSetChanged()
    }
}
