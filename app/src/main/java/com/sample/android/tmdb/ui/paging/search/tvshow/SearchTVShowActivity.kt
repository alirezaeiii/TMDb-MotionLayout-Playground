package com.sample.android.tmdb.ui.paging.search.tvshow

import androidx.activity.viewModels
import com.sample.android.tmdb.R
import com.sample.android.tmdb.ui.paging.search.SearchActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchTVShowActivity: SearchActivity() {

    override val fragment: SearchTVShowFragment
        get() = SearchTVShowFragment()

    override val hintId: Int
        get() = R.string.menu_tv_series

    override val searchViewModel: SearchTVShowViewModel by viewModels()
}