package com.sample.android.tmdb.ui.paging.main.tvshow

import com.sample.android.tmdb.domain.model.SortType.HIGHEST_RATED
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HighRateTVShowFragment : TVShowPagingFragment() {

    override val sortType = HIGHEST_RATED
}