package com.linuxias.smsdeliver

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.linuxias.smsdeliver.databinding.ActivityMainBinding
import com.linuxias.smsdeliver.others.TAG
import com.linuxias.smsdeliver.ui.history.HistoryFragment
import com.linuxias.smsdeliver.ui.filterlist.ListFragment
import com.linuxias.smsdeliver.ui.setting.MoreSettingFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var historyFragment: Fragment
    private lateinit var listFragment: Fragment
    private lateinit var moreSettingFragment: Fragment
    private var selectedFragment: Fragment ?= null

    private val permissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { result ->
        if (result.all { it.value }) {
            Log.i(TAG, "All required permissions granted")
        } else {
            Log.w(TAG, "Not all required permissions granted")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        historyFragment = HistoryFragment()
        listFragment = ListFragment()
        moreSettingFragment = MoreSettingFragment()

        supportFragmentManager.beginTransaction().replace(R.id.container, listFragment).commit()

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.histroy -> selectedFragment = historyFragment
                R.id.more -> selectedFragment = moreSettingFragment
                R.id.list -> selectedFragment = listFragment
            }
            selectedFragment?.let {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, it)
                    .commit()
            }
            true
        }

        permissionLauncher.launch(REQUIRED_PERMISSIONS)
    }

    private companion object {
        val REQUIRED_PERMISSIONS = arrayOf(
            Manifest.permission.RECEIVE_SMS,
            Manifest.permission.SEND_SMS
        )
    }
}