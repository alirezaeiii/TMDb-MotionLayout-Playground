package com.sample.android.tmdb.ui.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sample.android.tmdb.ui.common.TmdbTheme
import com.sample.android.tmdb.ui.common.composeView

class SettingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = composeView {
        TmdbTheme {
            SettingsScreen()
        }
    }
}