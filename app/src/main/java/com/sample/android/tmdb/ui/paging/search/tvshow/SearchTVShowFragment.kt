package com.sample.android.tmdb.ui.paging.search.tvshow

import androidx.fragment.app.activityViewModels
import com.sample.android.tmdb.ui.paging.search.BaseSearchFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchTVShowFragment : BaseSearchFragment() {

    override val viewModel: SearchTVShowViewModel by activityViewModels()
}