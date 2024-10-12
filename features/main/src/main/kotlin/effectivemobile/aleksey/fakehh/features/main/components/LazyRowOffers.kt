package effectivemobile.aleksey.fakehh.features.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.dimensionResource
import effectivemobile.aleksey.fakehh.common.ui.R
import effectivemobile.aleksey.fakehh.features.main.data.MainScreenState

@Composable
internal fun LazyRowOffers(
    state: MainScreenState,
    contentPadding: PaddingValues = PaddingValues(dimensionResource(R.dimen.general_padding_16))
) {
    LazyRow(
        contentPadding = contentPadding,
        horizontalArrangement = Arrangement.spacedBy(
            space = dimensionResource(R.dimen.general_padding_8),
            alignment = Alignment.Start
        )
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