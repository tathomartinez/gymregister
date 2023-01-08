package com.tatho.gymregister.rutina.ui.item

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tatho.gymregister.databinding.FragmentShowProgressExerciseItemBinding
import com.tatho.gymregister.ejercicio.data.Exercise
import com.tatho.gymregister.repeticion.data.Repeticion
import com.tatho.gymregister.repeticion.ui.adapter.RepeticionAdapter

class RuntimeItemExerciseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var binding = FragmentShowProgressExerciseItemBinding.bind(view)
    private var repeticionesList = mutableListOf<Repeticion>()
    private var adapter = RepeticionAdapter(repeticionesList)
    private val linearLayoutManager = LinearLayoutManager(view.context)
    private val viewPool = RecyclerView.RecycledViewPool()

    init {
        binding.rvRepeticion.adapter = adapter
        binding.rvRepeticion.setRecycledViewPool(viewPool)
        binding.rvRepeticion.layoutManager = linearLayoutManager
    }

    fun bind(item: Exercise) {
//        Log.e("EXERCISE", item.nameExercise)
        binding.tvExercise.text = item.nameExercise
        Log.e("EXERCISE", item.series.toString())
        item.series.let { series ->
            series.forEach { repeticionesList.add(it) }
        }

        adapter.notifyDataSetChanged()
    }
}