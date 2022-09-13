package com.willmiranda.inviting.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.willmiranda.inviting.model.GuestModel
import com.willmiranda.inviting.repository.GuestRepository

class GuestFormViewModel(application: Application): AndroidViewModel(application) {

    private val repository = GuestRepository.getInstance(application)

    fun insert(guest: GuestModel){

        repository.insert(guest)

    }

}