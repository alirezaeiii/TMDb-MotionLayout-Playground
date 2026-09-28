package com.sample.android.tmdb.ui.paging.main.movie

import com.sample.android.tmdb.domain.model.SortType.MOST_POPULAR
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularMoviesFragment : MoviePagingFragment() {

    override val sortType = MOST_POPULAR
}