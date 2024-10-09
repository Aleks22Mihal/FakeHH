package effectivemobile.aleksey.fakehh.features.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import effectivemobile.aleksey.fakehh.common.ui.R
import effectivemobile.aleksey.fakehh.features.main.data.MainScreenState

@Composable
internal fun SortingElementView(
    state: MainScreenState,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = pluralStringResource(
                R.plurals.vacancies_number,
                state.infoScreen.vacancies.size,
                state.infoScreen.vacancies.size
            ),
            color = Color.White,
            style = MaterialTheme.typography.bodyMedium
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.Start)
        ) {
            Text(
                text = stringResource(R.string.sorting_text),
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.bodyMedium
            )
            Image(
                painter = painterResource(R.drawable.icon_sorting_16dp),
                contentDescription = stringResource(R.string.sorting_text)
            )
        }
    }
}