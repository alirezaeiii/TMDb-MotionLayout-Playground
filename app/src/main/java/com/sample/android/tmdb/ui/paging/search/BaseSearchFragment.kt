package com.sample.android.tmdb.ui.paging.search

import android.os.Bundle
import android.view.View
import com.sample.android.tmdb.ui.paging.BasePagingFragment

abstract class BaseSearchFragment : BasePagingFragment() {

    abstract override val viewModel: BaseSearchViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.query.observe(viewLifecycleOwner) { q ->
            if (q.isNullOrBlank()) {
                tmdbAdapter.submitList(null)
            }
        }
    }
}