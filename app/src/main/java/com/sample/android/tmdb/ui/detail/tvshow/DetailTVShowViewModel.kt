package com.sample.android.tmdb.ui.detail.tvshow

import com.sample.android.tmdb.domain.model.TmdbItem
import com.sample.android.tmdb.domain.repository.TVShowDetailRepository
import com.sample.android.tmdb.ui.detail.DetailViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel(assistedFactory = DetailTVShowViewModel.Factory::class)
class DetailTVShowViewModel @AssistedInject constructor(
    repository: TVShowDetailRepository,
    @Assisted item: TmdbItem
) : DetailViewModel(
    repository.getTVShowTrailers(item.id),
    repository.getTVShowCredit(item.id)
) {
    @AssistedFactory
    interface Factory {
        fun create(item: TmdbItem): DetailTVShowViewModel
    }
}