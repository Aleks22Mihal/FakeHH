package effectivemobile.aleksey.fakehh.features.favorite.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import effectivemobile.aleksey.fakehh.features.favorite.FavoriteScreen
import effectivemobile.aleksey.fakehh.fetures.vacancy.navigation.vacancyScreen
import kotlinx.serialization.Serializable

@Serializable
object FavoriteRoute {
    @Serializable
    internal data object FavoriteScreenRoute
}

fun NavGraphBuilder.favoriteScreen(navController: NavController) {
    navigation<FavoriteRoute>(
        startDestination = FavoriteRoute.FavoriteScreenRoute
    ) {
        composable<FavoriteRoute.FavoriteScreenRoute> {
            FavoriteScreen(navController = navController)
        }
        vacancyScreen(navController)
    }

}