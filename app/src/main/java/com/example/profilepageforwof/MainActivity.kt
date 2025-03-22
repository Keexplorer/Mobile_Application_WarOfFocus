package com.example.profilepageforwof

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.profilepageforwof.Adapter.CategoryAdapter
import com.example.profilepageforwof.Adapter.ContentAdapter
import com.example.profilepageforwof.Domain.ContentDomain
import com.example.profilepageforwof.Repository.ProfileRepository

class MainActivity : AppCompatActivity() {
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var contentAdapter: ContentAdapter
    private val repository = ProfileRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerViewCategories = findViewById<RecyclerView>(R.id.Categories)
        val recyclerViewContents = findViewById<RecyclerView>(R.id.Contents)

        // Kategori Adapter'i tanımla
        categoryAdapter = CategoryAdapter(repository.categoryItems) { selectedCategory ->
            updateContent(selectedCategory)
        }
        recyclerViewCategories.adapter = categoryAdapter
        recyclerViewCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // İçerik Adapter'i tanımla
        contentAdapter = ContentAdapter(emptyList())
        recyclerViewContents.adapter = contentAdapter
        recyclerViewContents.layoutManager = LinearLayoutManager(this)
        updateContent("Başarımlarım")
    }

    private fun updateContent(category: String) {
        val filteredContent = when (category) {
            "Başarımlarım" -> repository.contentItems
            "İstatistiklerim" -> repository.statsItem
            "Avatarım" -> listOf(ContentDomain("Avatarını Güncelle"))
            else -> repository.contentItems
        }
        contentAdapter.updateContent(filteredContent)
    }

}
