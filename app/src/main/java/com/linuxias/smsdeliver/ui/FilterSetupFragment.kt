package com.linuxias.smsdeliver.ui

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.linuxias.smsdeliver.R
import com.linuxias.smsdeliver.databinding.FragmentFilterSetupBinding
import com.linuxias.smsdeliver.databinding.FragmentListBinding

class FilterSetupFragment : DialogFragment() {
    private var _binding: FragmentFilterSetupBinding? = null
    private val binding get() = _binding!!

    override fun onCreateDialog(
        savedInstanceState: Bundle?
    ): Dialog {
        _binding = FragmentFilterSetupBinding.inflate(LayoutInflater.from(context))
        return AlertDialog.Builder(requireActivity())
            .setView(binding.root)
            .create()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}