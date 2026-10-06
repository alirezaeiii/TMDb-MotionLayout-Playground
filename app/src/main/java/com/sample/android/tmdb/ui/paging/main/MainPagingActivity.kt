package com.sample.android.tmdb.ui.paging.main

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.sample.android.tmdb.R
import com.sample.android.tmdb.databinding.ActivityMainBinding
import com.sample.android.tmdb.domain.model.SortType
import com.sample.android.tmdb.ui.base.BaseNavigationActivity
import com.sample.android.tmdb.util.Constants.EXTRA_SORT_TYPE
import com.sample.android.tmdb.util.addFragmentToActivity
import com.sample.android.tmdb.util.setupActionBar

abstract class MainPagingActivity : BaseNavigationActivity() {

    private lateinit var binding: ActivityMainBinding

    protected abstract val fragment: BaseMainPagingFragment

    protected abstract val subTitleResId: Int

    protected val sortType: SortType
        get() = intent.getParcelableExtra(EXTRA_SORT_TYPE)!!

    protected open val titleResId: Int
        get() = when (sortType) {
            SortType.TRENDING -> R.string.trending
            SortType.MOST_POPULAR -> R.string.popular
            SortType.UPCOMING -> R.string.upcoming
            SortType.HIGHEST_RATED -> R.string.highest_rate
            SortType.NOW_PLAYING -> R.string.now_playing
            SortType.DISCOVER -> R.string.discover
        }

    override val toolbar: Toolbar
        get() = binding.toolbar

    override val networkStatusLayout: View by lazy { binding.itemContainer.networkStatusLayout }

    override val textViewNetworkStatus: TextView by lazy { binding.itemContainer.textViewNetworkStatus }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupActionBar(binding.toolbar) {
            setDisplayHomeAsUpEnabled(true)
        }
        title = getString(titleResId, getString(subTitleResId))
        if (savedInstanceState == null) {
            addFragmentToActivity(fragment, R.id.fragment_container)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}