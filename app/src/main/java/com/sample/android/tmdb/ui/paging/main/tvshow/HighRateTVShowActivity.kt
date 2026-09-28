package com.sample.android.tmdb.ui.paging.main.tvshow

import com.sample.android.tmdb.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HighRateTVShowActivity: TVShowPagingActivity() {

    override val titleId: Int
        get() = R.string.highest_rate

    override val fragment: TVShowPagingFragment
        get() = HighRateTVShowFragment()
}