package com.linuxias.smsdeliver.ui.filtersetup

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.linuxias.smsdeliver.data.FilterDatabase
import com.linuxias.smsdeliver.data.FilterRepository
import com.linuxias.smsdeliver.databinding.FragmentFilterSetupBinding
import com.linuxias.smsdeliver.ui.FilterViewModel
import com.linuxias.smsdeliver.ui.FilterViewModelFactory

class FilterSetupFragment : DialogFragment() {
    private val filterViewModel: FilterViewModel by activityViewModels() {
        FilterViewModelFactory(FilterRepository(FilterDatabase.getDatabase(requireActivity()).filterDao()))
    }

    private var _binding: FragmentFilterSetupBinding? = null
    private val binding get() = _binding!!

    override fun onCreateDialog(
        savedInstanceState: Bundle?
    ): Dialog {
        _binding = FragmentFilterSetupBinding.inflate(LayoutInflater.from(context))

        binding.btnSave.setOnClickListener {
            val receiverNumber = binding.editTextPhone.text.toString()
            val filterRegex = binding.editTextRegex.text.toString()
            filterViewModel.insertFilter(receiverNumber, filterRegex)
            findNavController().popBackStack()
        }

        return AlertDialog.Builder(requireActivity())
            .setView(binding.root)
            .create()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}