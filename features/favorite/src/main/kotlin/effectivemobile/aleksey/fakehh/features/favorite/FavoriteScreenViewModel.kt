package effectivemobile.aleksey.fakehh.features.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import effectivemobile.aleksey.fakehh.common.models.LoadState
import effectivemobile.aleksey.fakehh.domain.models.Vacancy
import effectivemobile.aleksey.fakehh.domain.usecase.DeleteItemFromFavoriteUseCase
import effectivemobile.aleksey.fakehh.domain.usecase.GetAllItemFromFavoriteCollectionUseCase
import effectivemobile.aleksey.fakehh.features.favorite.data.FavoriteScreenEvent
import effectivemobile.aleksey.fakehh.features.favorite.data.FavoriteScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class FavoriteScreenViewModel @Inject constructor(
    private val getAllItemFromFavoriteCollectionUseCase: GetAllItemFromFavoriteCollectionUseCase,
    private val deleteItemFromFavoriteUseCase: DeleteItemFromFavoriteUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(FavoriteScreenState())
    internal var state: StateFlow<FavoriteScreenState> = _state.asStateFlow()

    init {
        getVacancy()
    }

    fun onEvent(event: FavoriteScreenEvent){
        when(event){
            is FavoriteScreenEvent.DeleteFromDatabase -> deleteFromDatabase(event.vacancy)
            FavoriteScreenEvent.Refresh -> getVacancy()
        }
    }

    private fun getVacancy() {
        _state.value = state.value.copy(
            loadingState = LoadState.Loading
        )
        viewModelScope.launch {
            try {
                getAllItemFromFavoriteCollectionUseCase().onEach { result ->
                    _state.value = state.value.copy(
                        listVacancies = result,
                        loadingState = LoadState.Success
                    )
                }.stateIn(viewModelScope)
            } catch (e: Exception) {
                _state.value = state.value.copy(
                    loadingState = LoadState.Error
                )
            }

        }
    }

    private fun deleteFromDatabase(vacancy: Vacancy){
        viewModelScope.launch {
            deleteItemFromFavoriteUseCase(vacancy)
        }
    }
}