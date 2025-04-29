package com.example.focusapp2.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.example.focusapp2.R

class ProfileFragment : Fragment() {
    private lateinit var categoryLayout: LinearLayout
    private lateinit var contentContainer: FrameLayout
    private val categories = listOf("Başarımlarım", "Avatarımı Güncelle")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        categoryLayout = view.findViewById(R.id.categoryLayout)
        contentContainer = view.findViewById(R.id.profileContentContainer)

        setupCategoryButtons()

        // Varsayılan ekran
        replaceInnerFragment(BasariFragment())

        return view
    }

    private fun setupCategoryButtons() {
        for (category in categories) {
            val button = Button(requireContext()).apply {
                text = category
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                   marginStart = 32
                    marginEnd = 32
                }

                setOnClickListener {
                    when (category) {
                        "Başarımlarım" -> replaceInnerFragment(BasariFragment())
                        "Avatarımı Güncelle" -> replaceInnerFragment(AvatarFragment())
                    }
                }
            }
            categoryLayout.addView(button)
        }
    }

    private fun replaceInnerFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.profileContentContainer, fragment)
            .commit()
    }
}