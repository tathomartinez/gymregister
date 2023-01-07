package com.tatho.gymregister

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tatho.gymregister.databinding.FragmentInitBinding

/**
 * A simple [Fragment] subclass.
 * Use the [InitFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InitFragment : Fragment() {
    private var _binding: FragmentInitBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInitBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.initFragment.setOnClickListener {
            findNavController().navigate(R.id.action_initFragment_to_rutinaFragment)
        }

    }
}