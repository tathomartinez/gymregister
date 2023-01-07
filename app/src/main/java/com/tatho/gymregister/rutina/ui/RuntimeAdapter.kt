package com.tatho.gymregister.rutina.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tatho.gymregister.R
import com.tatho.gymregister.rutina.model.RuntimeExercise

class RuntimeAdapter(val dataSet: List<RuntimeExercise>) :
    RecyclerView.Adapter<RuntimeExerciseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RuntimeExerciseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RuntimeExerciseViewHolder(
            layoutInflater.inflate(
                R.layout.fragment_show_progress_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RuntimeExerciseViewHolder, position: Int) {
        val item: RuntimeExercise = dataSet[position]
        holder.bind(item)
    }

    override fun getItemCount() = dataSet.size

}
