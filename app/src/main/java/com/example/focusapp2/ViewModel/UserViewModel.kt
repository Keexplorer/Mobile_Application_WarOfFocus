package com.example.focusapp2.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.focusapp2.Model.User

class UserViewModel : ViewModel() {
    private val _user =MutableLiveData<User>()
    val user : LiveData<User> = _user

    fun setUser(mail : String, name: String, password : String){
        _user.value = User(mail,name,password)
    }

    fun getUserMail() : String{
        return _user.value?.user_mail ?: "0"
    }

    fun getUserName() : String{
        return _user.value?.user_name ?: "0"
    }

    fun getUserPassword() : String{
        return _user.value?.user_password ?: "0"
    }

}