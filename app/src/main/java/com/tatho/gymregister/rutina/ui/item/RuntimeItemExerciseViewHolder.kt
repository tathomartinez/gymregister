package com.tatho.gymregister.rutina.ui.item

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tatho.gymregister.databinding.FragmentShowProgressExerciseItemBinding
import com.tatho.gymregister.ejercicio.data.Exercise
import com.tatho.gymregister.repeticion.data.Repeticion

class RuntimeItemExerciseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var binding = FragmentShowProgressExerciseItemBinding.bind(view)
    private  var repeticionesList = mutableListOf<Repeticion>()
    fun bind(item: Exercise) {
        Log.e("EXERCISE", item.nameExercise)
        binding.tvExercise.text = item.nameExercise
//        binding.rvExercise.
    }
}