package com.example.profilepageforwof.ViewModel

import androidx.lifecycle.ViewModel
import com.example.profilepageforwof.Repository.ProfileRepository

class ProfileViewModel(val repository: ProfileRepository):ViewModel(){
    constructor():this(ProfileRepository())
    fun loadDataContent()=repository.contentItems
    fun loadDataCategory() = repository.categoryItems
}