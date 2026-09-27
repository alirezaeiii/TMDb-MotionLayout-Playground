package com.sample.android.tmdb.ui.detail

import android.view.MenuItem
import com.sample.android.tmdb.domain.model.TmdbItem
import com.sample.android.tmdb.ui.base.BaseDetailActivity
import com.sample.android.tmdb.util.Constants.EXTRA_TMDB_ITEM

abstract class DetailActivity : BaseDetailActivity() {

    protected val tmdbItem: TmdbItem by lazy {
        intent.extras?.getParcelable(EXTRA_TMDB_ITEM)!!
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