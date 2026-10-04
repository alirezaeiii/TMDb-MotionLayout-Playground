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
import com.sample.android.tmdb.util.addFragmentToActivity
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

    private var feedMovieFragment: FeedMovieFragment? = null
    private var feedTVShowFragment: FeedTVShowFragment? = null
    private var settingFragment: SettingFragment? = null

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
        if (savedInstanceState == null) {
            binding.navView.setCheckedItem(R.id.action_movies)
            feedMovieFragment = FeedMovieFragment()
            addFragmentToActivity(feedMovieFragment!!, R.id.fragment_container, TAG_MOVIE)
        } else {
            val fm = supportFragmentManager

            feedMovieFragment =
                fm.findFragmentByTag(TAG_MOVIE) as? FeedMovieFragment

            feedTVShowFragment =
                fm.findFragmentByTag(TAG_TV) as? FeedTVShowFragment

            settingFragment =
                fm.findFragmentByTag(TAG_SETTING) as? SettingFragment
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
                    showFragment(
                        feedMovieFragment ?: FeedMovieFragment().also { feedMovieFragment = it },
                        TAG_MOVIE
                    )
                }

                R.id.action_tv_series -> {
                    viewModel.setType(
                        R.string.menu_tv_series,
                        NavType.TV_SERIES
                    )
                    showFragment(
                        feedTVShowFragment ?: FeedTVShowFragment().also { feedTVShowFragment = it },
                        TAG_TV
                    )
                }

                R.id.action_setting -> {
                    viewModel.setType(
                        R.string.menu_setting,
                        NavType.SETTING
                    )
                    showFragment(
                        settingFragment ?: SettingFragment().also { settingFragment = it },
                        TAG_SETTING
                    )
                }

                else -> error("Unknown navigation item")
            }

            invalidateOptionsMenu()
            true
        }
    }

    private fun showFragment(fragment: Fragment, tag: String) {
        val fm = supportFragmentManager

        fm.beginTransaction().apply {
            fm.fragments.filter {
                it.isAdded && !it.isHidden
            }.forEach { hide(it) }

            if (!fragment.isAdded) {
                add(R.id.fragment_container, fragment, tag)
            } else {
                show(fragment)
            }
            commit()
        }
    }

    companion object {
        private const val TAG_MOVIE = "movie"
        private const val TAG_TV = "tv"
        private const val TAG_SETTING = "setting"
    }
}