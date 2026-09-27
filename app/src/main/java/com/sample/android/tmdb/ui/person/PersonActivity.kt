package com.sample.android.tmdb.ui.person

import androidx.fragment.app.Fragment
import com.sample.android.tmdb.domain.model.Credit
import com.sample.android.tmdb.ui.base.BaseDetailActivity
import com.sample.android.tmdb.util.Constants.CREDIT
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonActivity : BaseDetailActivity() {

    private val credit: Credit by lazy {
        intent.extras?.getParcelable(CREDIT)!!
    }

    override val fragment: Fragment
        get() = PersonFragment.newInstance(credit)
}
