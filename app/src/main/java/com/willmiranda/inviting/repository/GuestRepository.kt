package com.willmiranda.inviting.repository

class GuestRepository private constructor() {



    companion object {
        private lateinit var repository: GuestRepository
        fun getInstance(): GuestRepository {
            if(!Companion::repository.isInitialized){
            repository = GuestRepository()

        }
        return repository
        }

        fun save(){

        }

    }
}