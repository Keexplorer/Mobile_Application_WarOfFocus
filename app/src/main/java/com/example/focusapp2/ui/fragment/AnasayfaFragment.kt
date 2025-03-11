package com.example.focusapp2.ui.fragment

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.focusapp2.R
import com.example.focusapp2.ViewModel.UserViewModel
import com.example.focusapp2.databinding.AvatarCardTasarimBinding
import com.example.focusapp2.databinding.FragmentAnasayfaBinding


class AnasayfaFragment : Fragment() {

   private lateinit var binding: FragmentAnasayfaBinding
    private val userViewModel : UserViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater,container,false)


        val cardBinding = binding.avatarCard

        val mail = userViewModel.getUserMail()
        val name = userViewModel.getUserName()
        val password = userViewModel.getUserPassword()

        cardBinding.textViewUser.text = "$mail $name $password"
        cardBinding.imageView.setImageResource(R.drawable.avatar2)

        cardBinding.button.setOnClickListener(){

            Navigation.findNavController(it).navigate(R.id.gecisSavas)

        }



        return binding.root



    }


}