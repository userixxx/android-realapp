package com.icm.realapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.icm.realapp.R
import com.icm.realapp.databinding.FragmentRecordBinding
import com.icm.realapp.viewmodels.ListRecordsViewModel
import com.icm.realapp.viewmodels.RecordViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class FragmentRecord : Fragment() {

    private var _binding: FragmentRecordBinding? = null
    private val viewModel by lazy { ViewModelProvider(this).get(RecordViewModel::class.java) }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRecordBinding.inflate(inflater, container, false)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}