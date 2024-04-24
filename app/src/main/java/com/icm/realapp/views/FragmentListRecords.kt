package com.icm.realapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.icm.realapp.R
import com.icm.realapp.databinding.FragmentListRecordsBinding
import com.icm.realapp.viewmodels.ListRecordsViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FragmentListRecords : Fragment() {

    private var _binding: FragmentListRecordsBinding? = null
    private val viewModel by lazy { ViewModelProvider(this).get(ListRecordsViewModel::class.java) }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentListRecordsBinding.inflate(inflater, container, false)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}