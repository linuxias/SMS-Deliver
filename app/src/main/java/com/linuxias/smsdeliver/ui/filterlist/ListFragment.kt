package com.linuxias.smsdeliver.ui.filterlist

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.linuxias.smsdeliver.databinding.FragmentListBinding
import com.linuxias.smsdeliver.ui.addeditfilter.AddEditFilterActivity

class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.filterAddBtn.setOnClickListener {
            startActivity(Intent(requireContext(), AddEditFilterActivity::class.java))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}