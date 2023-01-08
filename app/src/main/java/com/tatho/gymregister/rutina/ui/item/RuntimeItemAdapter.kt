package com.tatho.gymregister.rutina.ui.item

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tatho.gymregister.R
import com.tatho.gymregister.ejercicio.data.Exercise

class RuntimeItemAdapter(val dataSet: List<Exercise>) :
    RecyclerView.Adapter<RuntimeItemExerciseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RuntimeItemExerciseViewHolder {
        Log.e("LLEGO","llego al oncreateView")
        val layoutInflater = LayoutInflater.from(parent.context)
        return RuntimeItemExerciseViewHolder(
            layoutInflater.inflate(
                R.layout.fragment_show_progress_exercise_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RuntimeItemExerciseViewHolder, position: Int) {
        Log.e("LLEGO","llego al onBindView")
        val item: Exercise = dataSet[position]
        holder.bind(item)
    }

    override fun getItemCount() = dataSet.size

}
