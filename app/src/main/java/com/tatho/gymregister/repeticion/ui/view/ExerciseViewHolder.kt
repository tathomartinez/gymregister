package com.tatho.gymregister.repeticion.ui.view

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tatho.gymregister.databinding.RegisterItemBinding
import com.tatho.gymregister.repeticion.data.Reps

class ExerciseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var binding = RegisterItemBinding.bind(view)
    var pesoValue = 0
    var reps = 0
    init {
        binding.txtPeso.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                pesoValue = if (p0.toString() == "") 0 else p0.toString().toInt()
            }

            override fun afterTextChanged(p0: Editable?) {
                // Trata de convertir el texto del EditText a un entero
                val value = p0.toString().toIntOrNull()

                // Si el valor es nulo o menor que 1, muestra un mensaje de error
                if (value == null || value < 1) {
                    binding.txtPeso.error = "El valor debe ser mayor que 0"
                } else {
                    // Si el valor es válido, quita el mensaje de error
                    binding.txtPeso.error = null
                }

            }

        })

        binding.txtReps.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                reps = if (p0.toString() == "") 0 else p0.toString().toInt()
            }

            override fun afterTextChanged(p0: Editable?) {
                // Trata de convertir el texto del EditText a un entero
                val value = p0.toString().toIntOrNull()

                // Si el valor es nulo o menor que 1, muestra un mensaje de error
                if (value == null || value < 1) {
                    binding.txtPeso.error = "El valor debe ser mayor que 0"
                } else {
                    // Si el valor es válido, quita el mensaje de error
                    binding.txtPeso.error = null
                }
            }

        })

    }

    fun bind(reps: Reps) {
        binding.txtPeso.setText(reps.peso.toString())
        binding.txtReps.setText(reps.reps.toString())
    }
}