package com.sample.android.tmdb.ui.feed.tvshow

import androidx.fragment.app.viewModels
import com.sample.android.tmdb.domain.model.TVShow
import com.sample.android.tmdb.ui.feed.FeedFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedTVShowFragment : FeedFragment<TVShow>() {

    override val viewModel: FeedTVShowViewModel by viewModels()
}