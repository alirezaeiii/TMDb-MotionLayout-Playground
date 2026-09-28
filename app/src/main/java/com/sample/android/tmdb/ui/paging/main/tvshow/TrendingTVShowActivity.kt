package com.sample.android.tmdb.ui.paging.main.tvshow

import com.sample.android.tmdb.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrendingTVShowActivity: TVShowPagingActivity() {

    override val titleId: Int
        get() = R.string.trending

    override val fragment: TVShowPagingFragment
        get() = TrendingTVShowFragment()
}