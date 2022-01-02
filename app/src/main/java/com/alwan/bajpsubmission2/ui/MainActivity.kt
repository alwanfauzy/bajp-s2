package com.alwan.bajpsubmission2.ui

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.alwan.bajpsubmission2.R
import com.alwan.bajpsubmission2.adapter.SectionsPagerAdapter
import com.alwan.bajpsubmission2.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.elevation = 0f

        setupViewPager()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setupViewPager() {
        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        val viewPager = binding.viewPagerCatalogue
        viewPager.adapter = sectionsPagerAdapter
        val tabs = binding.tabsCatalogue
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.menu_language -> {
                startActivity(Intent(Settings.ACTION_LOCALE_SETTINGS))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2
        )
    }
}
