package effectivemobile.aleksey.fakehh.fetures.vacancy.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import effectivemobile.aleksey.fakehh.fetures.vacancy.VacancyScreen
import kotlinx.serialization.Serializable

@Serializable
data object VacancyScreenRoute

fun NavGraphBuilder.vacancyScreen(navController: NavController) {
    composable<VacancyScreenRoute>{
        VacancyScreen(navController = navController)
    }
}