package com.sample.android.tmdb.ui.paging

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.android.tmdb.databinding.TmdbItemBinding
import com.sample.android.tmdb.domain.model.TmdbItem
import com.sample.android.tmdb.util.layoutInflater

class TmdbItemViewHolder(val binding: TmdbItemBinding)
    : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(parent: ViewGroup, tmdbClickCallback: TmdbClickCallback<TmdbItem>): TmdbItemViewHolder {
            val binding: TmdbItemBinding = TmdbItemBinding.inflate(parent.context.layoutInflater,
                    parent, false)
            binding.callback = tmdbClickCallback
            return TmdbItemViewHolder(binding)
        }
    }
}