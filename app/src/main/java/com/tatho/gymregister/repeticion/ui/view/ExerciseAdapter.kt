package com.tatho.gymregister.repeticion.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tatho.gymregister.R
import com.tatho.gymregister.repeticion.data.Reps

class ExerciseAdapter(val dataSet: List<Reps>) :
    RecyclerView.Adapter<ExerciseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ExerciseViewHolder(layoutInflater.inflate(R.layout.register_item,parent,false))
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val item: Reps = dataSet[position]
        holder.bind(item)
    }
}