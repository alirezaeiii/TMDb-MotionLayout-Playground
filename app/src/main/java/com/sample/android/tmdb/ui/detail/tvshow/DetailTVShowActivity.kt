package com.sample.android.tmdb.ui.detail.tvshow

import com.sample.android.tmdb.ui.detail.DetailActivity
import com.sample.android.tmdb.ui.detail.DetailFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailTVShowActivity: DetailActivity()  {

    override val fragment: DetailFragment
        get() = DetailTVShowFragment.newInstance(tmdbItem)
}