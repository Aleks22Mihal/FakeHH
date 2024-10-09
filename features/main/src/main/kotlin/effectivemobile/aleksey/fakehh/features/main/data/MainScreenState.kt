package effectivemobile.aleksey.fakehh.features.main.data

import effectivemobile.aleksey.fakehh.common.models.LoadState
import effectivemobile.aleksey.fakehh.domain.models.InfoScreen

internal data class MainScreenState(
    val searchText: String = "",
    val isClickButtonMore: Boolean = false,
    val loadingState: LoadState = LoadState.Success,
    val infoScreen: InfoScreen = InfoScreen(
        offers = emptyList(),
        vacancies = emptyList()
    )
)
