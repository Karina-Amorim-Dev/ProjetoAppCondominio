package com.example.appcondominio

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MuralAdapter (private  val mural : List<String>) : RecyclerView.Adapter<MuralAdapter.MuralViewHolder>() {

    class MuralViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titulo: TextView = itemView.findViewById(R.id.txtTitulo)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        p1: Int
    ): MuralAdapter.MuralViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mural, parent, false)
        return MuralViewHolder(view)
    }

    override fun onBindViewHolder(holder: MuralAdapter.MuralViewHolder, position: Int) {
        val mural = mural[position]
        holder.titulo.text = mural
    }

    override fun getItemCount(): Int {
        return mural.size
    }


}

