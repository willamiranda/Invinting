package com.willmiranda.inviting.view.viewholder

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.recyclerview.widget.RecyclerView
import com.willmiranda.inviting.databinding.RowGuestBinding
import com.willmiranda.inviting.model.GuestModel
import com.willmiranda.inviting.view.listener.OnGuestListener

class GuestViewHolder(private val bind: RowGuestBinding, private val listener: OnGuestListener) :
    RecyclerView.ViewHolder(bind.root) {

    fun bind(guest: GuestModel) {
        bind.textName.text = guest.name

        bind.textName.setOnClickListener {
            listener.onClick(guest.id)
        }
        bind.textName.setOnLongClickListener {
            AlertDialog.Builder(itemView.context)
                .setTitle("Remoção de convidado")
                .setMessage("Tem certeza que deseja remover?")
                .setPositiveButton("Sim") { dialog, which ->
                    listener.onDelete(guest.id)
                }
                .setNegativeButton("Não", null)
                .create()
                .show()


            true
        }

    }
}