package com.kevin.bottomnavigationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kevin.bottomnavigationdemo.databinding.ActivityMainBinding
import com.kevin.bottomnavigationdemo.fragments.HomeFragment
import com.kevin.bottomnavigationdemo.fragments.NotificationsFragment
import com.kevin.bottomnavigationdemo.fragments.SettingsFragment

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {

        // initial fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, HomeFragment.newInstance())
            .commit()
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, HomeFragment.newInstance())
                        .commit()
                    true
                }

                R.id.settings -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, SettingsFragment.newInstance())
                        .commit()
                    true
                }

                R.id.navigation_notifications -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, NotificationsFragment.newInstance())
                        .commit()
                    true
                }

                else -> false
            }
        }
    }
}