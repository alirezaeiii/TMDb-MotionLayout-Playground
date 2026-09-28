package com.sample.android.tmdb.ui.detail.tvshow

import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.sample.android.tmdb.domain.model.TmdbItem
import com.sample.android.tmdb.ui.detail.DetailFragment
import com.sample.android.tmdb.ui.detail.movie.DetailMovieViewModel
import com.sample.android.tmdb.util.Constants.EXTRA_TMDB_ITEM
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.withCreationCallback

@AndroidEntryPoint
class DetailTVShowFragment : DetailFragment() {


    override val viewModel: DetailMovieViewModel by viewModels(
        extrasProducer = {
            defaultViewModelCreationExtras.withCreationCallback<DetailMovieViewModel.Factory> { factory ->
                factory.create(item)
            }
        })

    companion object {

        fun newInstance(item: TmdbItem): DetailTVShowFragment {
            return DetailTVShowFragment().apply {
                arguments = bundleOf(EXTRA_TMDB_ITEM to item)
            }
        }
    }
}