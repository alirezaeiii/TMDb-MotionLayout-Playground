package com.sample.android.tmdb.ui.detail

import com.sample.android.tmdb.domain.model.CreditWrapper
import com.sample.android.tmdb.domain.model.DetailWrapper
import com.sample.android.tmdb.domain.model.Video
import com.sample.android.tmdb.ui.base.BaseDetailViewModel
import io.reactivex.Single

fun combineDetail(
    trailers: Single<List<Video>>,
    credits: CreditWrapper,
): Single<DetailWrapper> =
    Single.zip(trailers, credits.cast, credits.crew) { videos, cast, crew ->
        DetailWrapper(videos, cast, crew)
    }

open class DetailViewModel(
    detail: Single<DetailWrapper>,
) : BaseDetailViewModel<DetailWrapper>(detail)