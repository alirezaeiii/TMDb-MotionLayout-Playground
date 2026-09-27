package com.sample.android.tmdb.ui.paging.main.movie

import com.sample.android.tmdb.domain.model.SortType.HIGHEST_RATED
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HighRateMoviesFragment : MoviePagingFragment() {

    override val sortType = HIGHEST_RATED
}