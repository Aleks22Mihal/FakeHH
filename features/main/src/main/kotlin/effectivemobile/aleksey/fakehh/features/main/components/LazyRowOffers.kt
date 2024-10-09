package effectivemobile.aleksey.fakehh.features.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import effectivemobile.aleksey.fakehh.features.main.data.MainScreenState

@Composable
internal fun LazyRowOffers(
    state: MainScreenState,
    contentPadding: PaddingValues = PaddingValues(16.dp)
) {
    LazyRow(
        contentPadding = contentPadding,
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start)
    ) {
        items(
            state.infoScreen.offers
        ) { offer ->
            CardRecommendationView(
                offer = offer
            )
        }
    }
}