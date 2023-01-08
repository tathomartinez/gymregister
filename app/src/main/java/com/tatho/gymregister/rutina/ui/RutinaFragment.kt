package com.tatho.gymregister.rutina.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.tatho.gymregister.R
import com.tatho.gymregister.databinding.FragmentRutinaBinding
import com.tatho.gymregister.repeticion.data.servicio.FireBaseService
import com.tatho.gymregister.rutina.model.RuntimeExercise


class RutinaFragment : Fragment() {

    private val fireBaseService = FireBaseService()
    private var _binding: FragmentRutinaBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        RuntimeExercise.userId = 10L
        _binding = FragmentRutinaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.newExercise.setOnClickListener {
            findNavController().navigate(R.id.action_rutinaFragment_to_registrarRepeticionFragment)
        }
        binding.saveRuntime.setOnClickListener {
            if (RuntimeExercise.exercises.isNotEmpty()) {
                fireBaseService.addRuntime(RuntimeExercise.getCurrent())
                Snackbar.make(view, "Rutina guardada", Snackbar.LENGTH_LONG)
                    .show()
                RuntimeExercise.clean()
            }else{
                Snackbar.make(view, "Por favor agrege minimo un ejercicio a su rutina", Snackbar.LENGTH_LONG)
                    .show()

            }
        }
        binding.btnShowProgress.setOnClickListener {
            findNavController().navigate(R.id.action_rutinaFragment_to_showProgressFragment)
        }
    }
}