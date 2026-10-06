package com.sample.android.tmdb.ui.paging.main.tvshow

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sample.android.tmdb.data.network.TVShowService
import com.sample.android.tmdb.domain.model.SortType
import com.sample.android.tmdb.ui.paging.main.BaseMainPagingFragment
import com.sample.android.tmdb.util.Constants.EXTRA_SORT_TYPE
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TVShowPagingFragment : BaseMainPagingFragment() {

    @Inject
    lateinit var api: TVShowService

    override val sortType: SortType
        get() = arguments?.getParcelable(EXTRA_SORT_TYPE)!!

    override val viewModel by lazy {
        ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return TVShowPagingViewModel(api, sortType, requireNotNull(activity).application) as T
            }
        })[TVShowPagingViewModel::class.java]
    }

    companion object {
        fun newInstance(sortType: SortType): TVShowPagingFragment {
            return TVShowPagingFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(EXTRA_SORT_TYPE, sortType)
                }
            }
        }
    }
}