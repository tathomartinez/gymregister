package com.tatho.gymregister.rutina.ui

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool
import com.tatho.gymregister.databinding.FragmentShowProgressItemBinding
import com.tatho.gymregister.ejercicio.data.Exercise
import com.tatho.gymregister.rutina.model.RuntimeExercise
import com.tatho.gymregister.rutina.ui.item.RuntimeItemAdapter

class RuntimeExerciseViewHolder(val view: View) :
    RecyclerView.ViewHolder(view) {
    private var binding = FragmentShowProgressItemBinding.bind(view)
    private var listExercise = mutableListOf<Exercise>()
    private val adapter = RuntimeItemAdapter(listExercise)
    private val linearLayoutManager = LinearLayoutManager(view.context)
    private val viewPool = RecycledViewPool()

    init {
        binding.rvExercise.adapter = adapter
        binding.rvExercise.setRecycledViewPool(viewPool)
        binding.rvExercise.layoutManager = linearLayoutManager
    }

    fun bind(runtimeExercise: RuntimeExercise) {
        binding.tvDate.text = (runtimeExercise.date)
        runtimeExercise.exercises?.let { exercises ->
            exercises.forEach {
                listExercise.add(it)
            }
        }
        adapter.notifyDataSetChanged()
    }
}