package effectivemobile.aleksey.fakehh.features.main.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import effectivemobile.aleksey.fakehh.common.models.OfferId
import effectivemobile.aleksey.fakehh.common.ui.R
import effectivemobile.aleksey.fakehh.common.ui.theme.FakeHHTheme
import effectivemobile.aleksey.fakehh.domain.models.Button
import effectivemobile.aleksey.fakehh.domain.models.Offer

@Composable
internal fun CardRecommendationView(
    offer: Offer
) {
    val context = LocalContext.current

    Card(
        shape = MaterialTheme.shapes.medium,
        onClick = {
            if (offer.link.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(offer.link))
                context.startActivity(intent)
            }
        },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onBackground
        ),
        modifier = Modifier
            .size(
                width = dimensionResource(R.dimen.card_recommendation_view_width),
                height = dimensionResource(R.dimen.card_recommendation_view_height)
            )
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.general_padding_8))
        ) {
            if (offer.id != null) {
                Box(
                    modifier = Modifier
                        .padding(top = dimensionResource(R.dimen.top_padding_10))
                        .size(dimensionResource(R.dimen.card_recommendation_view_box_icon_size))
                        .background(
                            color =
                            if (offer.id == OfferId.NearVacancies)
                                MaterialTheme.colorScheme.onSecondary
                            else MaterialTheme.colorScheme.onPrimary,
                            shape = MaterialTheme.shapes.extraLarge
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(
                            when (offer.id) {
                                OfferId.NearVacancies -> R.drawable.crash_icon_near_vacancies_24dp // отсутствовала в верстке
                                OfferId.LevelUpResume -> R.drawable.icon_level_up_resume_24dp
                                OfferId.TemporaryJob -> R.drawable.icon_temporary_job_24dp
                                else -> R.drawable.icon_temporary_job_24dp
                            }
                        ),
                        contentDescription = stringResource(R.string.content_description_icon_in_card_recommended)
                    )
                }
            }

            Text(
                text = offer.title,
                style = MaterialTheme.typography.titleLarge,
                overflow = TextOverflow.Ellipsis,
                maxLines = if (offer.button != null) 2 else 3,
                textAlign = TextAlign.Start,
                color = Color.White,
                modifier = Modifier.padding(
                    top = dimensionResource(R.dimen.top_padding_16),
                )
            )
            if (offer.button != null) {
                Text(
                    text = offer.button?.text ?: "",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewCardRecommendationView() {
    FakeHHTheme {
        CardRecommendationView(
            offer = Offer(
                id = OfferId.TemporaryJob,
                title = "Вакансии рядом с вами",
                link = "https://hh.ru/",
                button = Button(
                    text = "Поднять"
                )
            )
        )
    }
}