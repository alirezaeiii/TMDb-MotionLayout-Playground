package com.sample.android.tmdb.ui.paging.main.tvshow

import com.sample.android.tmdb.domain.model.SortType.UPCOMING
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnTheAirTVShowFragment : TVShowPagingFragment() {

    override val sortType = UPCOMING
}