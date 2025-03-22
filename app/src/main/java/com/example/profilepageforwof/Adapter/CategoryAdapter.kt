package com.example.profilepageforwof.Adapter

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.profilepageforwof.R

class CategoryAdapter(
    private val categories: List<String>,
    private val onCategoryClick: (String) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val categoryText: TextView = view.findViewById(R.id.categoryText)
        val categoryImage: ImageView = view.findViewById(R.id.pic)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_categories, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.categoryText.text = category

        // Kategoriye göre uygun resmi ata
        val imageRes = when (category) {
            "Başarımlarım" -> R.drawable.trophy
            "İstatistiklerim" -> R.drawable.stats
            "Avatarım" -> R.drawable.ozan
            else -> R.drawable.ozan // Varsayılan resim
        }

        holder.categoryImage.setImageResource(imageRes)

        // Kategoriye tıklanınca içerik listesini güncelle
        holder.itemView.setOnClickListener {
            onCategoryClick(category)
        }
    }

    override fun getItemCount(): Int = categories.size
}
