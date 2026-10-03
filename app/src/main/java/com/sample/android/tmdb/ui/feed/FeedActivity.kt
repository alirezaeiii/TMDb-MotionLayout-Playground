package com.sample.android.tmdb.ui.feed

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.sample.android.tmdb.R
import com.sample.android.tmdb.databinding.ActivityFeedBinding
import com.sample.android.tmdb.ui.base.BaseNavigationActivity
import com.sample.android.tmdb.ui.feed.movie.FeedMovieFragment
import com.sample.android.tmdb.ui.feed.tvshow.FeedTVShowFragment
import com.sample.android.tmdb.ui.setting.SettingFragment
import com.sample.android.tmdb.util.addFragmentToActivity
import com.sample.android.tmdb.util.replaceFragmentInActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class FeedActivity : BaseNavigationActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityFeedBinding

    override val navType: NavType
        get() = viewModel.currentType.value ?: NavType.MOVIES

    override val toolbar: Toolbar
        get() = binding.toolbar

    override val networkStatusLayout: View by lazy { binding.itemContainer.networkStatusLayout }

    override val textViewNetworkStatus: TextView by lazy { binding.itemContainer.textViewNetworkStatus }

    private lateinit var feedMovieFragment: FeedMovieFragment
    private lateinit var feedTVShowFragment: FeedTVShowFragment
    private lateinit var settingFragment: SettingFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        viewModel.headline.observe(this) {
            title = getString(it)
        }

        feedMovieFragment =
            (supportFragmentManager.findFragmentByTag(TAG_MOVIE) as? FeedMovieFragment)
                ?.also { Timber.d("FeedMovieFragment restored: %s", it) } ?: FeedMovieFragment()
        feedTVShowFragment =
            (supportFragmentManager.findFragmentByTag(TAG_TV) as? FeedTVShowFragment)
                ?.also { Timber.d("FeedTVShowFragment restored: %s", it) } ?: FeedTVShowFragment()
        settingFragment =
            (supportFragmentManager.findFragmentByTag(TAG_SETTING) as? SettingFragment)
                ?.also { Timber.d("FeedSettingFragment restored: %s", it) } ?: SettingFragment()

        if (savedInstanceState == null) {
            addFragmentToActivity(feedMovieFragment, R.id.fragment_container, TAG_MOVIE)
            binding.navView.setCheckedItem(R.id.action_movies)
        }
        setupNavigationView()

        val toggle = ActionBarDrawerToggle(
            this, binding.drawerLayout, binding.toolbar,
            R.string.open_nav_drawer, R.string.close_nav_drawer
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun setupNavigationView() {
        binding.navView.setNavigationItemSelectedListener { item ->
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            val (fragment, tag) = when (item.itemId) {
                R.id.action_movies -> {
                    viewModel.setType(R.string.menu_movies, NavType.MOVIES)
                    Pair(feedMovieFragment, TAG_MOVIE)
                }

                R.id.action_tv_series -> {
                    viewModel.setType(R.string.menu_tv_series, NavType.TV_SERIES)
                    Pair(feedTVShowFragment, TAG_TV)

                }

                R.id.action_setting -> {
                    viewModel.setType(R.string.menu_setting, NavType.SETTING)
                    Pair(settingFragment, TAG_SETTING)

                }

                else -> throw RuntimeException("Unknown item to replace fragment")
            }
            invalidateOptionsMenu()
            replaceFragmentInActivity(fragment, R.id.fragment_container, tag)
            true
        }
    }

    companion object {
        private const val TAG_MOVIE = "movie"
        private const val TAG_TV = "tv"
        private const val TAG_SETTING = "setting"
    }
}