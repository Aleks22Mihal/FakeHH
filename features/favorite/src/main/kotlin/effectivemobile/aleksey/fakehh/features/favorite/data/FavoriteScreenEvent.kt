package effectivemobile.aleksey.fakehh.features.favorite.data

import effectivemobile.aleksey.fakehh.domain.models.Vacancy

internal sealed class FavoriteScreenEvent {
    data object Refresh: FavoriteScreenEvent()
    data class DeleteFromDatabase(val vacancy: Vacancy): FavoriteScreenEvent()
}