package effectivemobile.aleksey.fakehh

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import effectivemobile.aleksey.fakehh.domain.usecase.GetCountFromFavoriteCollectionUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class MainViewModel @Inject constructor(
    private val getCountFromFavoriteCollectionUseCase: GetCountFromFavoriteCollectionUseCase
) : ViewModel() {

    val itemCountInFavoriteCollection = getCountFromFavoriteCollectionUseCase().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = 0
    )
}