package com.sample.android.tmdb.ui.base

import androidx.lifecycle.ViewModel
import com.sample.android.tmdb.util.NetworkUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NetworkViewModel @Inject constructor(private val networkUtils: NetworkUtils) : ViewModel() {

    val networkLiveData = networkUtils.networkLiveData

    init {
        networkUtils.observeNetwork()
    }

    override fun onCleared() {
        super.onCleared()
        networkUtils.unregister()
    }
}