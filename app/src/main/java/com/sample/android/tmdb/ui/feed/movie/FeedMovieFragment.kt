package com.sample.android.tmdb.ui.feed.movie

import androidx.fragment.app.viewModels
import com.sample.android.tmdb.domain.model.Movie
import com.sample.android.tmdb.ui.feed.FeedFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedMovieFragment : FeedFragment<Movie>() {

    override val viewModel: FeedMovieViewModel by viewModels()
}