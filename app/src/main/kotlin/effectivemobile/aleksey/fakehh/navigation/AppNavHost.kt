package effectivemobile.aleksey.fakehh.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import effectivemobile.aleksey.fakehh.common.ui.R
import effectivemobile.aleksey.fakehh.common.ui.components.FakeScreen
import effectivemobile.aleksey.fakehh.features.favorite.navigation.favoriteScreen
import effectivemobile.aleksey.fakehh.features.main.navigation.MainRoute
import effectivemobile.aleksey.fakehh.features.main.navigation.mainScreen
import effectivemobile.aleksey.fakehh.navigation.data.FakeScreenRout

@Composable
internal fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = MainRoute,
        modifier = modifier
    ) {

        mainScreen(navController)

        favoriteScreen(navController)

        composable<FakeScreenRout.ResponseScreenRout> {
            FakeScreen(R.string.responses)
        }
        composable<FakeScreenRout.MessageScreenRout> {
            FakeScreen(R.string.messages)
        }
        composable<FakeScreenRout.ProfileScreenRout> {
            FakeScreen(R.string.profile)
        }
    }
}
