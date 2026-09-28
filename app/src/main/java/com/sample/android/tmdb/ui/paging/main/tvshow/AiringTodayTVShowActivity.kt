package com.sample.android.tmdb.ui.paging.main.tvshow

import com.sample.android.tmdb.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AiringTodayTVShowActivity: TVShowPagingActivity() {

    override val titleId: Int
        get() = R.string.airing_today

    override val fragment: TVShowPagingFragment
        get() = AiringTodayTVShowsFragment()
}