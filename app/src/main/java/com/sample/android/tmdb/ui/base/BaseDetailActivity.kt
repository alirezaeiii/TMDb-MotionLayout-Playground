package com.sample.android.tmdb.ui.base

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.sample.android.tmdb.R
import com.sample.android.tmdb.databinding.ActivityDetailBinding
import com.sample.android.tmdb.util.addFragmentToActivity

abstract class BaseDetailActivity : BaseActivity() {

    private lateinit var binding: ActivityDetailBinding

    override val networkStatusLayout: View by lazy { binding.itemContainer.networkStatusLayout }

    override val textViewNetworkStatus: TextView by lazy { binding.itemContainer.textViewNetworkStatus }

    protected abstract val fragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            addFragmentToActivity(fragment, R.id.fragment_container)
        }
    }
}