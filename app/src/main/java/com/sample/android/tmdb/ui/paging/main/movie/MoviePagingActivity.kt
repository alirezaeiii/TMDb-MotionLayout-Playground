package com.sample.android.tmdb.ui.paging.main.movie

import com.sample.android.tmdb.R
import com.sample.android.tmdb.ui.feed.NavType
import com.sample.android.tmdb.ui.paging.main.BaseMainPagingFragment
import com.sample.android.tmdb.ui.paging.main.MainPagingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviePagingActivity : MainPagingActivity() {

    override val subTitleResId: Int
        get() = R.string.menu_movies

    override val navType: NavType
        get() = NavType.MOVIES

    override val fragment: BaseMainPagingFragment
        get() = MoviePagingFragment.newInstance(sortType)
}