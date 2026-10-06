package com.sample.android.tmdb.ui.paging.main.movie

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import androidx.test.InstrumentationRegistry
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.sample.android.tmdb.domain.model.SortType
import com.sample.android.tmdb.ui.paging.main.BaseMainActivity
import com.sample.android.tmdb.util.Constants.EXTRA_SORT_TYPE
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class TestTopRatedMovies : BaseMainActivity() {

    @Rule
    @JvmField
    val activityTestRule: ActivityTestRule<MoviePagingActivity> =
        object : ActivityTestRule<MoviePagingActivity>(
            MoviePagingActivity::class.java
        ) {
            override fun getActivityIntent(): Intent {
                val targetContext: Context =
                    InstrumentationRegistry.getInstrumentation().targetContext
                return Intent(targetContext, MoviePagingActivity::class.java).apply {
                    putExtra(EXTRA_SORT_TYPE, SortType.HIGHEST_RATED as Parcelable)
                }
            }
        }

    override val title: String
        get() = "Top Rated Movies"
}