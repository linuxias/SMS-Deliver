package com.linuxias.smsdeliver.ui.setting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.linuxias.smsdeliver.R
import com.linuxias.smsdeliver.databinding.FragmentListBinding
import com.linuxias.smsdeliver.databinding.FragmentMoreSettingBinding

class MoreSettingFragment : Fragment() {
    private var _binding: FragmentMoreSettingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoreSettingBinding.inflate(inflater, container, false)
        binding.moreSettingComposeView.setContent {
            example()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

@Composable
fun example() {
    Text(
        "Test"
    )
}