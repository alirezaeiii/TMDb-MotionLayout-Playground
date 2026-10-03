package com.sample.android.tmdb.ui.feed

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.sample.android.tmdb.R
import com.sample.android.tmdb.databinding.ActivityFeedBinding
import com.sample.android.tmdb.ui.base.BaseNavigationActivity
import com.sample.android.tmdb.ui.feed.movie.FeedMovieFragment
import com.sample.android.tmdb.ui.feed.tvshow.FeedTVShowFragment
import com.sample.android.tmdb.ui.setting.SettingFragment
import dagger.hilt.android.AndroidEntryPoint

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
        setupFragments(savedInstanceState)
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

    private fun setupFragments(savedInstanceState: Bundle?) {
        val fm = supportFragmentManager

        if (savedInstanceState == null) {
            binding.navView.setCheckedItem(R.id.action_movies)
            feedMovieFragment = FeedMovieFragment()
            feedTVShowFragment = FeedTVShowFragment()
            settingFragment = SettingFragment()

            fm.beginTransaction()
                .add(R.id.fragment_container, feedMovieFragment, TAG_MOVIE)
                .add(R.id.fragment_container, feedTVShowFragment, TAG_TV)
                .add(R.id.fragment_container, settingFragment, TAG_SETTING)
                .hide(feedTVShowFragment)
                .hide(settingFragment)
                .commit()
        } else {
            feedMovieFragment =
                fm.findFragmentByTag(TAG_MOVIE) as FeedMovieFragment

            feedTVShowFragment =
                fm.findFragmentByTag(TAG_TV) as FeedTVShowFragment

            settingFragment =
                fm.findFragmentByTag(TAG_SETTING) as SettingFragment
        }
    }

    private fun setupNavigationView() {
        binding.navView.setNavigationItemSelectedListener { item ->
            binding.drawerLayout.closeDrawer(GravityCompat.START)

            when (item.itemId) {
                R.id.action_movies -> {
                    viewModel.setType(
                        R.string.menu_movies,
                        NavType.MOVIES
                    )
                    selectFragment(feedMovieFragment)
                }

                R.id.action_tv_series -> {
                    viewModel.setType(
                        R.string.menu_tv_series,
                        NavType.TV_SERIES
                    )
                    selectFragment(feedTVShowFragment)
                }

                R.id.action_setting -> {
                    viewModel.setType(
                        R.string.menu_setting,
                        NavType.SETTING
                    )
                    selectFragment(settingFragment)
                }

                else -> error("Unknown navigation item")
            }

            invalidateOptionsMenu()
            true
        }
    }

    private fun selectFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .hide(feedMovieFragment)
            .hide(feedTVShowFragment)
            .hide(settingFragment)
            .show(fragment)
            .commit()
    }

    companion object {
        private const val TAG_MOVIE = "movie"
        private const val TAG_TV = "tv"
        private const val TAG_SETTING = "setting"
    }
}