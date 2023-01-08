package com.tatho.gymregister.repeticion.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tatho.gymregister.R
import com.tatho.gymregister.repeticion.data.Repeticion

class RepeticionAdapter(val dataSet: MutableList<Repeticion>) :
    RecyclerView.Adapter<RepeticionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepeticionViewHolder {
        Log.e("mislogs", "items")
        val layoutInflater = LayoutInflater.from(parent.context)
        return RepeticionViewHolder(
            layoutInflater.inflate(
                R.layout.fragment_show_progress_repeticion_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RepeticionViewHolder, position: Int) {
        Log.e("mislogs", "items")
        val item: Repeticion = dataSet[position]
        holder.bind(item)
    }

    override fun getItemCount() = dataSet.size
}