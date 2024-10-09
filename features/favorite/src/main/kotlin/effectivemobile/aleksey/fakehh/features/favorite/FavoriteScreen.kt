package effectivemobile.aleksey.fakehh.features.favorite

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import effectivemobile.aleksey.fakehh.common.models.LoadState
import effectivemobile.aleksey.fakehh.common.ui.R
import effectivemobile.aleksey.fakehh.common.ui.components.CardVacancyView
import effectivemobile.aleksey.fakehh.common.ui.components.ErrorView
import effectivemobile.aleksey.fakehh.features.favorite.data.FavoriteScreenEvent
import effectivemobile.aleksey.fakehh.fetures.vacancy.navigation.VacancyScreenRoute

@Composable
internal fun FavoriteScreen(
    viewModel: FavoriteScreenViewModel = hiltViewModel(),
    navController: NavController,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    when (state.loadingState) {
        LoadState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        LoadState.Error -> {
            ErrorView(
                onClickForRefresh = {
                    viewModel.onEvent(FavoriteScreenEvent.Refresh)
                }
            )
        }

        LoadState.Success -> {
            LazyColumn {
                item {
                    Text(
                        text = stringResource(R.string.favorite),
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.White,
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .padding(top = 32.dp)

                    )
                }
                item {
                    Text(
                        text = pluralStringResource(
                            R.plurals.count_vacancies,
                            state.listVacancies.size,
                            state.listVacancies.size
                        ),
                        color = MaterialTheme.colorScheme.surfaceContainerLow,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .padding(top = 24.dp, bottom = 16.dp)
                    )
                }
                items(state.listVacancies) { vacancy ->
                    CardVacancyView(
                        vacancy = vacancy,
                        onClick = { navController.navigate(VacancyScreenRoute) },
                        onClickFavorite = {
                            viewModel.onEvent(FavoriteScreenEvent.DeleteFromDatabase(vacancy))
                        },
                    )
                }
            }
        }
    }
}