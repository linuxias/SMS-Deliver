package com.linuxias.smsdeliver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.linuxias.smsdeliver.ui.HistoryFragment
import com.linuxias.smsdeliver.ui.ListFragment
import com.linuxias.smsdeliver.ui.MoreSettingFragment

class MainActivity : AppCompatActivity() {
    private lateinit var historyFragment: Fragment
    private lateinit var listFragment: Fragment
    private lateinit var moreSettingFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        historyFragment = HistoryFragment()
        listFragment = ListFragment()
        moreSettingFragment = MoreSettingFragment()

        supportFragmentManager.beginTransaction().replace(R.id.container, listFragment).commit()

        val bottomnavigationView = findViewById(R.id.bottom_navigation) as NavigationBarView
        bottomnavigationView.setOnItemSelectedListener (
            object: NavigationBarView.OnItemSelectedListener {
                override fun onNavigationItemSelected(item: MenuItem): Boolean {
                    var selectedFragment: Fragment ?= null
                    when(item.itemId) {
                        R.id.histroy -> selectedFragment = historyFragment
                        R.id.more -> selectedFragment = moreSettingFragment
                        R.id.list -> selectedFragment = listFragment
                    }
                    selectedFragment?.let {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.container, selectedFragment)
                            .commit()
                        return true
                    }
                    return false
                }
            }
        )
    }
}