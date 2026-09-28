package com.sample.android.tmdb.ui.paging.main.tvshow

import com.sample.android.tmdb.domain.model.SortType.MOST_POPULAR
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularTVShowFragment : TVShowPagingFragment() {

    override val sortType = MOST_POPULAR
}