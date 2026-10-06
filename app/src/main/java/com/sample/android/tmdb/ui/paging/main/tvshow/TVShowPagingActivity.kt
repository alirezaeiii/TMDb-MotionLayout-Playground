package com.sample.android.tmdb.ui.paging.main.tvshow

import com.sample.android.tmdb.R
import com.sample.android.tmdb.domain.model.SortType
import com.sample.android.tmdb.ui.feed.NavType
import com.sample.android.tmdb.ui.paging.main.BaseMainPagingFragment
import com.sample.android.tmdb.ui.paging.main.MainPagingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TVShowPagingActivity : MainPagingActivity() {

    override val subTitleResId: Int
        get() = R.string.menu_tv_series

    override val titleResId: Int
        get() = when (sortType) {
            SortType.UPCOMING -> R.string.on_the_air
            SortType.NOW_PLAYING -> R.string.airing_today
            else -> super.titleResId
        }

    override val navType: NavType
        get() = NavType.TV_SERIES

    override val fragment: BaseMainPagingFragment
        get() = TVShowPagingFragment.newInstance(sortType)
}