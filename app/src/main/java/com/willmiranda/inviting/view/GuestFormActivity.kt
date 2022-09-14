package com.willmiranda.inviting.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.willmiranda.inviting.R
import com.willmiranda.inviting.constants.DataBaseConstants
import com.willmiranda.inviting.databinding.ActivityGuestFormBinding
import com.willmiranda.inviting.model.GuestModel
import com.willmiranda.inviting.viewmodel.GuestFormViewModel

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityGuestFormBinding
    private lateinit var viewModel: GuestFormViewModel

    private var guestId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGuestFormBinding.inflate(layoutInflater)

        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        binding.buttonSave.setOnClickListener(this)
        binding.radioPresent.isChecked = true

        observe()
        loadData()


    }

    override fun onClick(v: View) {
        if(v.id == R.id.button_save){
            val name = binding.editName.text.toString()
            val presence =  binding.radioPresent.isChecked
            val model = GuestModel(guestId,name,presence)

            viewModel.save(model)

            //TODO Temp
            finish()
        }
    }

    private fun observe(){
        viewModel.guest.observe(this, Observer {
            binding.editName.setText(it.name)
            if(it.presence){
                binding.radioPresent.isChecked = true
            }else{
                binding.radioAbsent.isChecked = true
            }
        })
    }

    private fun loadData(){
        val bundle = intent.extras
        if(bundle != null){
            guestId = bundle.getInt(DataBaseConstants.GUEST.ID)
            viewModel.get(guestId)
        }
    }
}