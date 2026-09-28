package com.sample.android.tmdb.ui.paging.search

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.sample.android.tmdb.domain.paging.BasePageKeyRepository
import com.sample.android.tmdb.domain.paging.Listing
import com.sample.android.tmdb.ui.paging.BasePagingViewModel

abstract class BaseSearchViewModel(app: Application) : BasePagingViewModel(app) {

    private val _query = MutableLiveData<String?>()
    val query: LiveData<String?> = _query

    protected abstract fun searchRepoResult(query : String) : BasePageKeyRepository

    override val repoResult: LiveData<Listing?> = query.map { q ->
        q?.let { searchRepoResult(it).getItems() }
    }

    fun showQuery(query: String): Boolean = this.query.value != query

    fun onQuerySubmitted(q: String) { _query.value = q }

    fun onQueryChanged(q: String) { _query.value = q }

    fun onQueryCleared() { _query.value = null }
}