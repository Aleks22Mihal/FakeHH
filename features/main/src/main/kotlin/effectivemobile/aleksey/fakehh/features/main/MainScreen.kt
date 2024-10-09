package effectivemobile.aleksey.fakehh.features.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import effectivemobile.aleksey.fakehh.features.main.components.LazyRowOffers
import effectivemobile.aleksey.fakehh.features.main.components.SearchBarView
import effectivemobile.aleksey.fakehh.features.main.components.SortingElementView
import effectivemobile.aleksey.fakehh.features.main.data.MainScreenEvent
import effectivemobile.aleksey.fakehh.fetures.vacancy.navigation.VacancyScreenRoute

@Composable
internal fun MainScreen(
    viewModel: MainScreenViewModel = hiltViewModel<MainScreenViewModel>(),
    navController: NavController,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    val countVacancies = 3

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
                modifier = Modifier.fillMaxSize()
            ) {
                viewModel.onEvent(MainScreenEvent.Refresh)
            }
        }

        LoadState.Success -> {

            LazyColumn(
                contentPadding = PaddingValues(top = 16.dp),
            ) {
                item {
                    SearchBarView(
                        state = state,
                        onEvent = viewModel::onEvent
                    )
                }
                item {
                    if (state.isClickButtonMore) {
                        SortingElementView(state = state)
                    } else LazyRowOffers(state = state)
                }
                item {
                    Text(
                        text = stringResource(R.string.vacancies_for_you),
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.White,
                        modifier = Modifier.padding(16.dp)

                    )
                }
                items(
                    if (state.isClickButtonMore) {
                        state.infoScreen.vacancies
                    } else state.infoScreen.vacancies.take(countVacancies)
                ) { vacancy ->
                    CardVacancyView(
                        vacancy = vacancy,
                        onClick = {
                            navController.navigate(VacancyScreenRoute)
                        },
                        onClickFavorite = {
                            viewModel.onEvent(
                                MainScreenEvent.ClickOnFavorite(
                                    vacancy
                                )
                            )
                        }
                    )
                }
                item {
                    if (!state.isClickButtonMore) {
                        Button(
                            onClick = {
                                viewModel.onEvent(MainScreenEvent.ClickButtonMore)
                            },
                            shape = MaterialTheme.shapes.medium,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.secondary
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    vertical = 8.dp,
                                    horizontal = 16.dp
                                )
                        ) {
                            Text(
                                text = pluralStringResource(
                                    R.plurals.vacancies_number,
                                    state.infoScreen.vacancies.size,
                                    state.infoScreen.vacancies.size
                                ),
                                color = Color.White,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                    }
                }
            }
        }
    }
}