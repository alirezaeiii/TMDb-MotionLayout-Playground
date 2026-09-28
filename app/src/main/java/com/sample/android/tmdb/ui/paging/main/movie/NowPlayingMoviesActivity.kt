package com.sample.android.tmdb.ui.paging.main.movie

import com.sample.android.tmdb.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NowPlayingMoviesActivity : MoviePagingActivity() {

    override val titleId: Int
        get() = R.string.now_playing

    override val fragment: MoviePagingFragment
        get() = NowPlayingMoviesFragment()
}