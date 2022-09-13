package com.willmiranda.inviting.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.willmiranda.inviting.databinding.RowGuestBinding
import com.willmiranda.inviting.model.GuestModel

class GuestViewHolder(private val bind: RowGuestBinding) : RecyclerView.ViewHolder(bind.root) {

    fun bind(guest: GuestModel){
        bind.textName.text = guest.name
    }
}