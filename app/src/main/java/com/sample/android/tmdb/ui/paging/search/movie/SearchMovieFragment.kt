package com.sample.android.tmdb.ui.paging.search.movie

import androidx.fragment.app.activityViewModels
import com.sample.android.tmdb.ui.paging.search.BaseSearchFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchMovieFragment : BaseSearchFragment() {

    override val viewModel: SearchMovieViewModel by activityViewModels()
}