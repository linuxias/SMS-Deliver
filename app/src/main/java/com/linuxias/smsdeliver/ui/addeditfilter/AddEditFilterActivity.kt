package com.linuxias.smsdeliver.ui.addeditfilter

import android.annotation.SuppressLint
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.linuxias.smsdeliver.data.FilterDatabase
import com.linuxias.smsdeliver.data.FilterRepositoryImpl
import com.linuxias.smsdeliver.databinding.ActivityFilterSetupBinding
import java.text.SimpleDateFormat
import java.util.*

class AddEditFilterActivity : AppCompatActivity() {
    private val filterViewModel: AddEditFilterViewModel by viewModels() {
        FilterViewModelFactory(FilterRepositoryImpl(FilterDatabase.getDatabase(this).filterDao()))
    }

    private var _binding: ActivityFilterSetupBinding? = null
    private val binding get() = _binding!!

    private var filterID: String? = null

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityFilterSetupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editTextPhone.addTextChangedListener(PhoneNumberFormattingTextWatcher())
        binding.tvCurrentDay.text = run {
            val now = System.currentTimeMillis()
            val date = Date(now)
            SimpleDateFormat("yyyy-MM-dd").format(date)
        }

        binding.btnBackFiltersetup.setOnClickListener {
            finish()
        }

        binding.btnSave.setOnClickListener {
            val receiverNumber = binding.editTextPhone.text.toString()
            val filterRegex = binding.editTextRegex.text.toString()

            filterViewModel.saveFilter(receiverNumber, filterRegex, filterID)

            finish()
        }
    }
}