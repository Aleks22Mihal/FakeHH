package effectivemobile.aleksey.fakehh.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import effectivemobile.aleksey.fakehh.common.ui.R
import effectivemobile.aleksey.fakehh.features.favorite.navigation.FavoriteRoute
import effectivemobile.aleksey.fakehh.features.main.navigation.MainRoute
import effectivemobile.aleksey.fakehh.navigation.data.FakeScreenRout
import effectivemobile.aleksey.fakehh.navigation.data.TopLevelRoute

@Composable
internal fun NavBottomBarView(
    navController: NavController,
    itemCountInFavorite: Int
) {
    val listTopLevelRoute = listOf(
        TopLevelRoute(
            textId = R.string.search,
            iconId = R.drawable.icon_search_24dp,
            route = MainRoute
        ),
        TopLevelRoute(
            textId = R.string.favorite,
            iconId = R.drawable.icon_favorite_24dp,
            route = FavoriteRoute
        ),
        TopLevelRoute(
            textId = R.string.responses,
            iconId = R.drawable.icon_email_24dp,
            route = FakeScreenRout.ResponseScreenRout
        ),
        TopLevelRoute(
            textId = R.string.messages,
            iconId = R.drawable.icon_message_24dp,
            route = FakeScreenRout.MessageScreenRout
        ),
        TopLevelRoute(
            textId = R.string.profile,
            iconId = R.drawable.icon_profile_24dp,
            route = FakeScreenRout.ProfileScreenRout
        )


    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
    ) {
        listTopLevelRoute.forEach { topLevelRoute ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                ),
                icon = {
                    BadgedBox(
                        badge = {
                            if (topLevelRoute.route == FavoriteRoute && itemCountInFavorite != 0) {
                                Badge(
                                    containerColor = MaterialTheme.colorScheme.onError,
                                    modifier = Modifier
                                        .size(dimensionResource(R.dimen.navigation_bar_badge_size))
                                        .align(Alignment.TopEnd)
                                ) {
                                    Text(
                                        text = itemCountInFavorite.toString(),
                                        style = MaterialTheme.typography.labelSmall,
                                        color = Color.White
                                    )
                                }
                            }
                        }
                    ) {
                        Icon(
                            painter = painterResource(topLevelRoute.iconId),
                            tint = when (currentDestination?.hierarchy?.any {
                                it.hasRoute(topLevelRoute.route::class)
                            } == true) {
                                true -> MaterialTheme.colorScheme.secondary
                                false -> MaterialTheme.colorScheme.surfaceContainerLow
                            },
                            contentDescription = stringResource(topLevelRoute.textId)
                        )
                    }
                },
                selected = currentDestination?.hierarchy?.any {
                    it.hasRoute(topLevelRoute.route::class)
                } == true,
                label = {
                    Text(
                        text = stringResource(topLevelRoute.textId),
                        style = MaterialTheme.typography.bodySmall,
                        color = when (currentDestination?.hierarchy?.any {
                            it.hasRoute(topLevelRoute.route::class)
                        } == true) {
                            true -> MaterialTheme.colorScheme.secondary
                            false -> MaterialTheme.colorScheme.surfaceContainerLow
                        },
                    )
                },
                alwaysShowLabel = true,
                onClick = {
                    navController.navigate(route = topLevelRoute.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}