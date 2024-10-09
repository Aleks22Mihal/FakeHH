package effectivemobile.aleksey.fakehh.features.main.data

import effectivemobile.aleksey.fakehh.domain.models.Vacancy

internal sealed class MainScreenEvent {
    data object Refresh: MainScreenEvent()
    data class ChangeText(val text: String): MainScreenEvent()
    data object ClickButtonMore: MainScreenEvent()
    data class ClickOnFavorite(val vacancy: Vacancy): MainScreenEvent()
}