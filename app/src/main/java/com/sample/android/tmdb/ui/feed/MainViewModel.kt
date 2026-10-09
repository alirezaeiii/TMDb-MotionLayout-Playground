package com.sample.android.tmdb.ui.feed

import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.sample.android.tmdb.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.parcelize.Parcelize
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _headline = savedStateHandle.getLiveData(HEAD_LINE, R.string.menu_movies)
    val headline: LiveData<Int>
        get() = _headline

    private val _currentType = savedStateHandle.getLiveData(NAV_TYPE, NavType.MOVIES)
    val currentType: LiveData<NavType>
        get() = _currentType

    fun setType(titleId: Int, navType: NavType) {
        savedStateHandle[HEAD_LINE] = titleId
        savedStateHandle[NAV_TYPE] = navType
    }

    companion object {
        private const val HEAD_LINE = "headline"
        private const val NAV_TYPE = "navType"
    }
}

@Parcelize
enum class NavType : Parcelable {
    MOVIES,
    TV_SERIES,
    SETTING
}