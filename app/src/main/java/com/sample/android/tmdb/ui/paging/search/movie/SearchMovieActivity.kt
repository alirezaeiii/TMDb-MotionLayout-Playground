package com.sample.android.tmdb.ui.paging.search.movie

import androidx.activity.viewModels
import com.sample.android.tmdb.R
import com.sample.android.tmdb.ui.paging.search.SearchActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchMovieActivity: SearchActivity() {

    override val fragment: SearchMovieFragment
        get() = SearchMovieFragment()

    override val hintId: Int
        get() = R.string.menu_movies

    override val searchViewModel: SearchMovieViewModel by viewModels()
}