package com.tatho.gymregister

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ExerciseAdapter(val dataSet: List<Reps>) :
    RecyclerView.Adapter<ExerciseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        Log.e("mislogs","items")
        val layoutInflater = LayoutInflater.from(parent.context)
        return ExerciseViewHolder(layoutInflater.inflate(R.layout.register_item,parent,false))
    }

    override fun getItemCount() = dataSet.size
    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        Log.d("EPISODIOS", "llego al bindView position:$position")
        val item: Reps = dataSet[position]
        holder.bind(item)
    }
}