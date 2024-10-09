package effectivemobile.aleksey.fakehh.navigation.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kotlinx.serialization.Serializable

internal data class TopLevelRoute<T : Any>(
    @DrawableRes val iconId: Int,
    @StringRes val textId: Int,
    val route: T,
)

internal sealed class FakeScreenRout {
    @Serializable
    data object ResponseScreenRout

    @Serializable
    data object MessageScreenRout

    @Serializable
    data object ProfileScreenRout
}