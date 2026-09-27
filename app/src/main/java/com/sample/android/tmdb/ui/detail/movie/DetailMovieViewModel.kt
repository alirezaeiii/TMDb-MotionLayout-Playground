package com.sample.android.tmdb.ui.detail.movie

import com.sample.android.tmdb.domain.model.TmdbItem
import com.sample.android.tmdb.domain.repository.MovieDetailRepository
import com.sample.android.tmdb.ui.detail.DetailViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel(assistedFactory = DetailMovieViewModel.Factory::class)
class DetailMovieViewModel @AssistedInject constructor(
    repository: MovieDetailRepository,
    @Assisted item: TmdbItem
) : DetailViewModel(
    repository.getMovieTrailers(item.id),
    repository.getMovieCredit(item.id)
) {
    @AssistedFactory
    interface Factory {
        fun create(item: TmdbItem): DetailMovieViewModel
    }
}