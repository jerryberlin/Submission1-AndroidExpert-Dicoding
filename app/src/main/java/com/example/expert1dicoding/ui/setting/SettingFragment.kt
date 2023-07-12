package com.example.expert1dicoding.ui.setting

import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.example.core.utils.DarkMode
import com.example.expert1dicoding.R
import java.util.*

class SettingFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)

        val pref = findPreference<ListPreference>(getString(R.string.pref_key_dark))
        pref?.onPreferenceChangeListener =
            Preference.OnPreferenceChangeListener { _, newValue ->
                val value = newValue as String
                val selectedMode = when (value.uppercase(Locale.US)) {
                    DarkMode.ON.name -> DarkMode.ON
                    DarkMode.OFF.name -> DarkMode.OFF
                    else -> DarkMode.FOLLOW_SYSTEM
                }
                updateTheme(selectedMode.value)
                true
            }
    }

    private fun updateTheme(mode: Int): Boolean {
        AppCompatDelegate.setDefaultNightMode(mode)
        requireActivity().recreate()
        return true
    }


}