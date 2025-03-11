package com.example.focusapp2.ui.fragment

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.focusapp2.R
import com.example.focusapp2.databinding.AvatarCardTasarimBinding
import com.example.focusapp2.databinding.FragmentAnasayfaBinding


class AnasayfaFragment : Fragment() {

   private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater,container,false)


        val cardBinding = binding.avatarCard

        cardBinding.imageView.setImageResource(R.drawable.avatar2)

        cardBinding.button.setOnClickListener(){

            Navigation.findNavController(it).navigate(R.id.gecisSavas)

        }



        return binding.root



    }


}