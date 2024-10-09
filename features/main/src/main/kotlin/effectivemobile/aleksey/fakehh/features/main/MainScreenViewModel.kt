package effectivemobile.aleksey.fakehh.features.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import effectivemobile.aleksey.fakehh.common.models.LoadState
import effectivemobile.aleksey.fakehh.common.utilities.onError
import effectivemobile.aleksey.fakehh.common.utilities.onSuccess
import effectivemobile.aleksey.fakehh.domain.models.Vacancy
import effectivemobile.aleksey.fakehh.domain.usecase.DeleteItemFromFavoriteUseCase
import effectivemobile.aleksey.fakehh.domain.usecase.GetResultUseCase
import effectivemobile.aleksey.fakehh.domain.usecase.InsertItemInFavoriteCollectionUseCase
import effectivemobile.aleksey.fakehh.features.main.data.MainScreenEvent
import effectivemobile.aleksey.fakehh.features.main.data.MainScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class MainScreenViewModel @Inject constructor(
    private val insertItemInFavoriteCollectionUseCase: InsertItemInFavoriteCollectionUseCase,
    private val deleteItemFromFavoriteUseCase: DeleteItemFromFavoriteUseCase,
    private val getResultUseCase: GetResultUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(MainScreenState())
    internal var state: StateFlow<MainScreenState> = _state.asStateFlow()

    init {
        getInfoScreen()
    }

    internal fun onEvent(event: MainScreenEvent) {
        when (event) {
            MainScreenEvent.Refresh -> getInfoScreen()

            is MainScreenEvent.ChangeText -> _state.value = state.value.copy(
                searchText = event.text
            )

            MainScreenEvent.ClickButtonMore -> _state.value = state.value.copy(
                isClickButtonMore = !state.value.isClickButtonMore
            )

            is MainScreenEvent.ClickOnFavorite -> onClickFavorite(event.vacancy)
        }
    }

    private fun getInfoScreen() {
        _state.value = state.value.copy(
            loadingState = LoadState.Loading
        )
        viewModelScope.launch {
            getResultUseCase().onEach { result ->
                result.onSuccess { data ->
                    _state.value = state.value.copy(
                        infoScreen = data,
                        loadingState = LoadState.Success
                    )
                }.onError {
                    _state.value = state.value.copy(loadingState = LoadState.Error)
                }
            }.stateIn(viewModelScope)
        }
    }

    private fun onClickFavorite(vacancy: Vacancy) {
        viewModelScope.launch {
            if (vacancy.isFavorite) {
                deleteItemFromFavoriteUseCase(vacancy)
            } else {
                insertItemInFavoriteCollectionUseCase(vacancy)
            }
        }
    }
}