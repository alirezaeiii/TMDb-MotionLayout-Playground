package com.sample.android.tmdb.ui.paging.main.movie

import com.sample.android.tmdb.domain.model.SortType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NowPlayingMoviesFragment : MoviePagingFragment() {

    override val sortType = SortType.NOW_PLAYING
}