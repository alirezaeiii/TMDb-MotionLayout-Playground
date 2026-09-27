package com.sample.android.tmdb.ui.paging.main.tvshow

import com.sample.android.tmdb.domain.model.SortType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiscoverTVShowsFragment : TVShowPagingFragment() {

    override val sortType = SortType.DISCOVER
}