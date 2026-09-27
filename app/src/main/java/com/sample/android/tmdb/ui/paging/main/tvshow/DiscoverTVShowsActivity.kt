package com.sample.android.tmdb.ui.paging.main.tvshow

import com.sample.android.tmdb.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiscoverTVShowsActivity : TVShowPagingActivity() {

    override val titleId: Int
        get() = R.string.discover

    override val fragment: TVShowPagingFragment
        get() = DiscoverTVShowsFragment()
}