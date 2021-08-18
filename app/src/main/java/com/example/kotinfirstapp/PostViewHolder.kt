package com.example.kotinfirstapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

class PostViewHolder(private val view :View):RecyclerView.ViewHolder(view){
    fun setData(responseDTOItem: ResponseDTOItem){
        view.apply {
            tvName.text=responseDTOItem.name
            tvBody.text=responseDTOItem.body
            tvEmail.text=responseDTOItem.email
        }
    }
}