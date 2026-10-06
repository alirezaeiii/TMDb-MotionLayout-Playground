package com.sample.android.tmdb.ui.paging.main.tvshow

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
class TestTrendingTVSeries : BaseMainActivity() {

    @Rule
    @JvmField
    val activityTestRule: ActivityTestRule<TVShowPagingActivity> =
        object : ActivityTestRule<TVShowPagingActivity>(
            TVShowPagingActivity::class.java
        ) {
            override fun getActivityIntent(): Intent {
                val targetContext: Context =
                    InstrumentationRegistry.getInstrumentation().targetContext
                return Intent(targetContext, TVShowPagingActivity::class.java).apply {
                    putExtra(EXTRA_SORT_TYPE, SortType.TRENDING as Parcelable)
                }
            }
        }

    override val title: String
        get() = "Trending TV Series"
}