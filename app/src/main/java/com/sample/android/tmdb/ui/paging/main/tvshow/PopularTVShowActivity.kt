package com.sample.android.tmdb.ui.paging.main.tvshow

import com.sample.android.tmdb.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PopularTVShowActivity: TVShowPagingActivity() {

    override val titleId: Int
        get() = R.string.popular

    override val fragment: TVShowPagingFragment
        get() = PopularTVShowFragment()
}