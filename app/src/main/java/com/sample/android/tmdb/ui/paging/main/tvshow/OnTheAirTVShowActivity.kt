package com.sample.android.tmdb.ui.paging.main.tvshow

import com.sample.android.tmdb.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnTheAirTVShowActivity: TVShowPagingActivity() {

    override val titleId: Int
        get() = R.string.on_the_air

    override val fragment: TVShowPagingFragment
        get() = OnTheAirTVShowFragment()
}