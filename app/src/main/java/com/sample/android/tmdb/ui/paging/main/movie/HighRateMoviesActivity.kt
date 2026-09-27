package com.sample.android.tmdb.ui.paging.main.movie

import com.sample.android.tmdb.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HighRateMoviesActivity: MoviePagingActivity() {

    override val titleId: Int
        get() = R.string.highest_rate

    override val fragment: MoviePagingFragment
        get() = HighRateMoviesFragment()
}