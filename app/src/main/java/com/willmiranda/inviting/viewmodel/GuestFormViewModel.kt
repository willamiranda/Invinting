package com.willmiranda.inviting.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.willmiranda.inviting.model.GuestModel
import com.willmiranda.inviting.repository.GuestRepository

class GuestFormViewModel(application: Application): AndroidViewModel(application) {

    private val repository = GuestRepository.getInstance(application)

    private val guestModel = MutableLiveData<GuestModel>()
    val guest: LiveData<GuestModel> = guestModel

    fun save(guest: GuestModel){

        if(guest.id == 0) {
            repository.insert(guest)
        }else{
            repository.update(guest)
        }
    }


    fun get(id: Int){
       guestModel.value = repository.get(id)
    }

}