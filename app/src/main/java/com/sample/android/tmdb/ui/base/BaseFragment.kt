package com.sample.android.tmdb.ui.base

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.sample.android.tmdb.domain.model.Movie
import com.sample.android.tmdb.domain.model.TVShow
import com.sample.android.tmdb.domain.model.TmdbItem
import com.sample.android.tmdb.ui.detail.movie.DetailMovieActivity
import com.sample.android.tmdb.ui.detail.tvshow.DetailTVShowActivity
import com.sample.android.tmdb.util.Constants.EXTRA_TMDB_ITEM

open class BaseFragment<VB: ViewDataBinding>: Fragment() {

    private var _binding: VB? = null

    protected val binding get() = _binding!!

    protected open fun setBinding(): VB? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = this.setBinding()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    protected fun startDetailActivity(tmdbItem: TmdbItem) {
        val activityClass = when (tmdbItem) {
            is Movie -> DetailMovieActivity::class.java
            is TVShow -> DetailTVShowActivity::class.java
            else -> throw RuntimeException("Unknown item to start detail Activity")
        }
        val intent = Intent(requireActivity(), activityClass).apply {
            putExtras(Bundle().apply {
                putParcelable(EXTRA_TMDB_ITEM, tmdbItem)
            })
        }
        startActivity(intent)
    }
}