package com.sample.android.tmdb.ui.feed.movie

import com.sample.android.tmdb.data.repository.MovieFeedRepository
import com.sample.android.tmdb.domain.model.Movie
import com.sample.android.tmdb.ui.feed.FeedViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FeedMovieViewModel @Inject constructor(repository: MovieFeedRepository) :
    FeedViewModel<Movie>(repository)