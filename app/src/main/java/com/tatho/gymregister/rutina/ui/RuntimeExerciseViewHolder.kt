package com.tatho.gymregister.rutina.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tatho.gymregister.databinding.FragmentShowProgressItemBinding
import com.tatho.gymregister.rutina.model.RuntimeExercise

class RuntimeExerciseViewHolder(view: View):RecyclerView.ViewHolder(view) {
    private var binding = FragmentShowProgressItemBinding.bind(view)
    fun bind(item: RuntimeExercise) {
        binding.tvDate.setText(item.date)    }
}