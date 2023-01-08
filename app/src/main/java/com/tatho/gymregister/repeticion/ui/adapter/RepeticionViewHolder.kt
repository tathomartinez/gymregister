package com.tatho.gymregister.repeticion.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tatho.gymregister.databinding.FragmentShowProgressItemBinding
import com.tatho.gymregister.databinding.FragmentShowProgressRepeticionItemBinding
import com.tatho.gymregister.repeticion.data.Repeticion

class RepeticionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var binding = FragmentShowProgressRepeticionItemBinding.bind(view)
    fun bind(item: Repeticion) {
        binding.textView2.text = "Peso : ${item.peso} Repeticion : ${item.repeticionMaxima}"
    }

}
