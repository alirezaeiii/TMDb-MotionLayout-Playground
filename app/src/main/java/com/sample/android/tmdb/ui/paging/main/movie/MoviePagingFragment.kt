package com.sample.android.tmdb.ui.paging.main.movie

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sample.android.tmdb.data.network.MovieService
import com.sample.android.tmdb.domain.model.SortType
import com.sample.android.tmdb.ui.paging.main.BaseMainPagingFragment
import com.sample.android.tmdb.util.Constants.EXTRA_SORT_TYPE
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MoviePagingFragment : BaseMainPagingFragment() {

    @Inject
    lateinit var api: MovieService

    override val sortType: SortType
        get() = arguments?.getParcelable(EXTRA_SORT_TYPE)!!

    override val viewModel by lazy {
        ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return MoviePagingViewModel(api, sortType, requireNotNull(activity).application) as T
            }
        })[MoviePagingViewModel::class.java]
    }

    companion object {
        fun newInstance(sortType: SortType): MoviePagingFragment {
            return MoviePagingFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(EXTRA_SORT_TYPE, sortType)
                }
            }
        }
    }
}