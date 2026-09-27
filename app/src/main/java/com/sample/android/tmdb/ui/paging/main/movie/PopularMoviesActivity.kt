package com.sample.android.tmdb.ui.paging.main.movie

import com.sample.android.tmdb.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularMoviesActivity: MoviePagingActivity() {

    override val titleId: Int
        get() = R.string.popular

    override val fragment: MoviePagingFragment
        get() = PopularMoviesFragment()
}