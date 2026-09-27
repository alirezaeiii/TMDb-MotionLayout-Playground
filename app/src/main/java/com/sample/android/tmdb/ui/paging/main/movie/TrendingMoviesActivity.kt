package com.sample.android.tmdb.ui.paging.main.movie

import com.sample.android.tmdb.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrendingMoviesActivity: MoviePagingActivity() {

    override val titleId: Int
        get() = R.string.trending

    override val fragment: MoviePagingFragment
        get() = TrendingMoviesFragment()
}