package com.tatho.gymregister.repeticion.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tatho.gymregister.R
import com.tatho.gymregister.databinding.FragmentRegistrarRepeticionBinding
import com.tatho.gymregister.ejercicio.data.Exercise
import com.tatho.gymregister.repeticion.data.Repeticion
import com.tatho.gymregister.repeticion.data.Reps
import com.tatho.gymregister.repeticion.ui.view.ExerciseAdapter
import com.tatho.gymregister.repeticion.ui.view.ExerciseViewHolder
import com.tatho.gymregister.rutina.model.RuntimeExercise

/**
 * A simple [Fragment] subclass.
 * Use the [RegistrarSessionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegistrarSessionFragment : Fragment() {
    private var _binding: FragmentRegistrarRepeticionBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private val items = mutableListOf<Reps>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrarRepeticionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = requireView().findViewById(R.id.exercises)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        items.add(Reps(0, 0))
        val adapter = ExerciseAdapter(items)
        recyclerView.adapter = adapter

        binding.save.setOnClickListener {
            val repeticionesMutableList = mutableListOf<Repeticion>()
            for (i in 0 until recyclerView.childCount) {
                val viewHolder =
                    recyclerView.findViewHolderForAdapterPosition(i) as ExerciseViewHolder
                val peso = viewHolder.pesoValue
                val repeticiones = viewHolder.reps
                repeticionesMutableList.add(Repeticion(peso, repeticiones))
//                Log.e("ITEMS", "peso : $peso , repeticiones: $repeticiones")
            }

            val exercise =
                Exercise(binding.textNombre.text.toString(), repeticionesMutableList)

            RuntimeExercise.exercises.add(exercise)

            cleanRegister(adapter)
            val navController = findNavController()
            navController.popBackStack()
        }

        binding.clean.setOnClickListener {
            cleanRegister(adapter)
        }

        binding.addSession.setOnClickListener {
            items.add(Reps(0, 0))
            adapter.notifyItemInserted(items.size - 1)
        }
    }

    private fun cleanRegister(adapter: ExerciseAdapter) {
        items.clear()
        items.add(Reps(0, 0))
        adapter.notifyDataSetChanged()
    }
}