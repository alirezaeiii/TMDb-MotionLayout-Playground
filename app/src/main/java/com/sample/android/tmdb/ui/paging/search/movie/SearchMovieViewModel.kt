package com.sample.android.tmdb.ui.paging.search.movie

import android.app.Application
import android.content.Context
import com.sample.android.tmdb.data.network.MovieService
import com.sample.android.tmdb.data.paging.search.movie.SearchMoviePageKeyRepository
import com.sample.android.tmdb.domain.paging.BasePageKeyRepository
import com.sample.android.tmdb.ui.paging.search.BaseSearchViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class SearchMovieViewModel @Inject constructor(
    private val api: MovieService,
    @ApplicationContext private val context: Context
) : BaseSearchViewModel(app = context as Application) {

    override fun searchRepoResult(query: String): BasePageKeyRepository =
        SearchMoviePageKeyRepository(api, query, networkIO, context.applicationContext)
}