package effectivemobile.aleksey.fakehh.features.main.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import effectivemobile.aleksey.fakehh.features.main.MainScreen
import effectivemobile.aleksey.fakehh.fetures.vacancy.navigation.vacancyScreen
import kotlinx.serialization.Serializable

@Serializable
object MainRoute {
    @Serializable
    data object MainScreenRoute
}

fun NavGraphBuilder.mainScreen(navController: NavController) {
    navigation<MainRoute>(
        startDestination = MainRoute.MainScreenRoute
    ) {
        composable<MainRoute.MainScreenRoute> {
            MainScreen(navController = navController)
        }
        vacancyScreen(navController)
    }

}