package com.sample.android.tmdb.ui.feed.tvshow

import com.sample.android.tmdb.domain.model.TVShow
import com.sample.android.tmdb.domain.repository.BaseFeedRepository
import com.sample.android.tmdb.ui.feed.FeedViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FeedTVShowViewModel @Inject constructor(repository: BaseFeedRepository<TVShow>) :
    FeedViewModel<TVShow>(repository)