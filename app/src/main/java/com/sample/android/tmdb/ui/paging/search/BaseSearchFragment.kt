package com.sample.android.tmdb.ui.paging.search

import android.os.Bundle
import android.view.View
import com.sample.android.tmdb.ui.paging.BasePagingFragment

abstract class BaseSearchFragment : BasePagingFragment() {

    private val searchViewModel
        get() = viewModel as BaseSearchViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchViewModel.query.observe(viewLifecycleOwner) {
            binding.recyclerView.scrollToPosition(0)
            tmdbAdapter.submitList(null)
        }
    }
}