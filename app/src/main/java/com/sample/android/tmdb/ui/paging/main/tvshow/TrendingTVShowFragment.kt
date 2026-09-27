package com.sample.android.tmdb.ui.paging.main.tvshow

import com.sample.android.tmdb.domain.model.SortType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrendingTVShowFragment : TVShowPagingFragment() {

    override val sortType = SortType.TRENDING
}