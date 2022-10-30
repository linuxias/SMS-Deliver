package com.linuxias.smsdeliver.ui.addeditfilter

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.linuxias.smsdeliver.data.FilterDatabase
import com.linuxias.smsdeliver.data.FilterRepositoryImpl
import com.linuxias.smsdeliver.databinding.FragmentFilterSetupBinding

class AddEditFilterFragment : DialogFragment() {
    private val filterViewModel: AddEditFilterViewModel by activityViewModels() {
        FilterViewModelFactory(FilterRepositoryImpl(FilterDatabase.getDatabase(requireActivity()).filterDao()))
    }

    private var _binding: FragmentFilterSetupBinding? = null
    private val binding get() = _binding!!

    private lateinit var filterID: String

    override fun onCreateDialog(
        savedInstanceState: Bundle?
    ): Dialog {
        _binding = FragmentFilterSetupBinding.inflate(LayoutInflater.from(context))

        binding.btnSave.setOnClickListener {
            val receiverNumber = binding.editTextPhone.text.toString()
            val filterRegex = binding.editTextRegex.text.toString()

            filterViewModel.saveFilter(filterID, receiverNumber, filterRegex)
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