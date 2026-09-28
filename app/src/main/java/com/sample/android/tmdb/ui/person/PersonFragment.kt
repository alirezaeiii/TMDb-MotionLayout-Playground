package com.sample.android.tmdb.ui.person

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.sample.android.tmdb.R
import com.sample.android.tmdb.databinding.FragmentPersonBinding
import com.sample.android.tmdb.domain.model.Credit
import com.sample.android.tmdb.ui.base.BaseDetailFragment
import com.sample.android.tmdb.util.Constants.CREDIT
import com.sample.android.tmdb.util.toVisibility
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.withCreationCallback

@AndroidEntryPoint
class PersonFragment : BaseDetailFragment<PersonViewModel, FragmentPersonBinding>() {

    private val credit: Credit by lazy {
        requireArguments().getParcelable(CREDIT)!!
    }

    override val viewModel: PersonViewModel by viewModels(
        extrasProducer = {
            defaultViewModelCreationExtras.withCreationCallback<PersonViewModel.Factory> { factory ->
                factory.create(credit.id)
            }
        })

    override fun setBinding() = FragmentPersonBinding.inflate(layoutInflater)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        with(binding) {
            person = credit
            personHeader.backBtn.setOnClickListener {
                activity?.finish()
            }

            viewModel.liveData.observe(viewLifecycleOwner) {
                biographyLabel.toVisibility(it.biography.trim().isNotEmpty())
                knownAs.toVisibility(it.alsoKnowAs.isNotEmpty())
                knownAs.text = getString(R.string.known_as, it.alsoKnowAs.joinToString())
            }
            biography.setOnClickListener {
                val maxLine = resources.getInteger(R.integer.max_lines)
                biography.maxLines = if (biography.maxLines > maxLine) maxLine else Int.MAX_VALUE
            }
        }
        return binding.root
    }

    companion object {

        fun newInstance(credit: Credit): PersonFragment {
            return PersonFragment().apply {
                arguments = bundleOf(CREDIT to credit)
            }
        }
    }
}
