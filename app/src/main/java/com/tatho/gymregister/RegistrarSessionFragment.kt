package com.tatho.gymregister

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tatho.gymregister.databinding.FragmentRegistrarRepeticionBinding
import com.tatho.gymregister.ejercicio.data.SessionExercise
import com.tatho.gymregister.repeticion.data.Repeticion
import com.tatho.gymregister.repeticion.data.servicio.FireBaseService

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

    private val serieService = FireBaseService()
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
                Log.e("ITEMS", "peso : $peso , repeticiones: $repeticiones")
            }

            val sessionExercise =
                SessionExercise(binding.textNombre.text.toString(), repeticionesMutableList)
            serieService.addExercise(sessionExercise)
        }

        binding.clean.setOnClickListener {
            items.clear()
            items.add(Reps(0, 0))
            adapter.notifyDataSetChanged()
        }

        binding.addSession.setOnClickListener {
            items.add(Reps(0, 0))
            adapter.notifyItemInserted(items.size - 1)
        }
    }
}