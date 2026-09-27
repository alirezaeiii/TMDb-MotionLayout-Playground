package com.sample.android.tmdb.ui.paging.search.tvshow

import android.app.Application
import android.content.Context
import com.sample.android.tmdb.data.network.TVShowService
import com.sample.android.tmdb.data.paging.search.tvshow.SearchTVShowPageKeyRepository
import com.sample.android.tmdb.domain.paging.BasePageKeyRepository
import com.sample.android.tmdb.ui.paging.search.BaseSearchViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class SearchTVShowViewModel @Inject constructor(
    private val api: TVShowService,
    @ApplicationContext private val context: Context
) : BaseSearchViewModel(app = context as Application) {

    override fun searchRepoResult(query: String): BasePageKeyRepository =
        SearchTVShowPageKeyRepository(api, query, networkIO, context.applicationContext)
}