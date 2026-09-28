package com.sample.android.tmdb.ui.person

import com.sample.android.tmdb.domain.model.Person
import com.sample.android.tmdb.domain.repository.PersonRepository
import com.sample.android.tmdb.ui.base.BaseDetailViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel(assistedFactory = PersonViewModel.Factory::class)
class PersonViewModel @AssistedInject constructor(
    repository: PersonRepository,
    @Assisted personId: String
) : BaseDetailViewModel<Person>(repository.getPerson(personId)) {

    @AssistedFactory
    interface Factory {
        fun create(personId: String): PersonViewModel
    }
}