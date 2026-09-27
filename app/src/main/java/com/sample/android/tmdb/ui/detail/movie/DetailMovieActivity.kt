package com.sample.android.tmdb.ui.detail.movie

import com.sample.android.tmdb.ui.detail.DetailActivity
import com.sample.android.tmdb.ui.detail.DetailFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailMovieActivity : DetailActivity() {

    override val fragment: DetailFragment
        get() = DetailMovieFragment.newInstance(tmdbItem)
}