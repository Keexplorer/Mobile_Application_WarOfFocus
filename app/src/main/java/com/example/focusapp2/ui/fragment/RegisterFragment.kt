package com.example.focusapp2.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.focusapp2.R
import com.example.focusapp2.ViewModel.UserViewModel
import com.example.focusapp2.databinding.ActivityRegisterScreenBinding

class RegisterFragment : Fragment() {
    private lateinit var binding: ActivityRegisterScreenBinding
    private val userViewModel : UserViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View{
        binding = ActivityRegisterScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.registerButton.setOnClickListener{
            val email = binding.emailEditText.text.toString()
            val name = binding.usernameEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            userViewModel.setUser(email,name,password)

            findNavController().navigate(R.id.Kayit)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}