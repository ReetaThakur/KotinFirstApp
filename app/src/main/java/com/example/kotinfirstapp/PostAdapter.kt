package com.example.kotinfirstapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(val responseDTO: ResponseDTO) : RecyclerView.Adapter<PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
    return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val model :ResponseDTOItem=responseDTO[position]
        holder.setData(model)
    }

    override fun getItemCount(): Int {
        return responseDTO.size
    }
}