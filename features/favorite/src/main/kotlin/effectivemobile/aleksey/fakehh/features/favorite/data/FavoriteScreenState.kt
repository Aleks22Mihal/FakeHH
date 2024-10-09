package effectivemobile.aleksey.fakehh.features.favorite.data

import effectivemobile.aleksey.fakehh.common.models.LoadState
import effectivemobile.aleksey.fakehh.domain.models.Vacancy

internal data class FavoriteScreenState(
    val listVacancies: List<Vacancy> = emptyList(),
    val loadingState: LoadState = LoadState.Success,
)