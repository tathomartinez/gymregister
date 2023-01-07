package com.tatho.gymregister.showprogress

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tatho.gymregister.R
import com.tatho.gymregister.databinding.FragmentShowProgressBinding
import com.tatho.gymregister.rutina.model.RuntimeExercise
import com.tatho.gymregister.rutina.ui.RuntimeAdapter
import com.tatho.gymregister.rutina.ui.RuntimeExerciseViewHolder


class ShowProgressFragment : Fragment() {

    private var _binding: FragmentShowProgressBinding? = null
    private val binding get() = _binding!!
    private val showProgressViewModel: ShowProgressViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerView.Adapter<RuntimeExerciseViewHolder>
    var runtimes = mutableListOf<RuntimeExercise>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShowProgressBinding.inflate(inflater, container, false)
        showProgressViewModel.observerRuntimesMutableLiveData.observe(viewLifecycleOwner) {
            it.forEach { runtime ->
                runtimes.add(runtime)
            }
            adapter.notifyItemInserted(runtimes.size - 1)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = requireView().findViewById(R.id.rvRutine)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = RuntimeAdapter(runtimes)
        recyclerView.adapter = adapter
        showProgressViewModel.getRuntime()
    }

}