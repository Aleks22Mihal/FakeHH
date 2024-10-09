package effectivemobile.aleksey.fakehh.common.ui.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import effectivemobile.aleksey.fakehh.common.ui.R
import effectivemobile.aleksey.fakehh.domain.models.Vacancy
import java.time.LocalDate

@Composable
fun CardVacancyView(
    vacancy: Vacancy,
    onClick: () -> Unit,
    onClickFavorite: () -> Unit,
) {
    val date = LocalDate.parse(vacancy.publishedDate)
    val context = LocalContext.current

    Card(
        onClick = {
            onClick()
        },
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.elevatedCardElevation(0.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onBackground
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(bottom = 16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                    modifier = Modifier.weight(0.8f)
                ) {
                    if (vacancy.lookingNumber != null) {
                        Text(
                            text = pluralStringResource(
                                R.plurals.looking_number,
                                vacancy.lookingNumber!!,
                                vacancy.lookingNumber!!,
                            ),
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                    Text(
                        text = vacancy.title,
                        color = Color.White,
                        style = MaterialTheme.typography.headlineSmall
                    )
                    if (!vacancy.salary.short.isNullOrBlank()) {
                        Text(
                            text = vacancy.salary.short ?: "",
                            color = Color.White,
                            style = MaterialTheme.typography.headlineLarge
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = vacancy.address.town,
                            color = Color.White,
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Row(
                            verticalAlignment = Alignment.Bottom,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = vacancy.company,
                                color = Color.White,
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Image(
                                painter = painterResource(R.drawable.icon_check_mark_16dp),
                                contentDescription = stringResource(
                                    R.string.icon_in_card_vacancy_the_company_is_verified
                                )
                            )
                        }
                    }
                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.icon_experience_16dp),
                            contentDescription = stringResource(R.string.icon_in_card_vacancy_experience)
                        )
                        Text(
                            text = vacancy.experience.previewText,
                            color = Color.White,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    Text(
                        text = stringResource(
                            R.string.published,
                            date.dayOfMonth,
                            stringArrayResource(R.array.month_declensions)[date.monthValue - 1]
                        ),
                        color = MaterialTheme.colorScheme.surfaceContainerLow,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Image(
                    painter = when (vacancy.isFavorite) {
                        true -> painterResource(R.drawable.icon_fill_favorite_24dp)
                        false -> painterResource(R.drawable.icon_favorite_24dp)
                    },
                    contentDescription = stringResource(R.string.favorite),
                    modifier = Modifier.clickable {
                        onClickFavorite()
                    }
                )

            }
            Button(
                onClick = {
                    val text = context.getText(R.string.the_response_has_been_sent)
                    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
                },
                shape = MaterialTheme.shapes.large,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Text(
                    text = stringResource(R.string.respond),
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White
                )
            }
        }
    }
}
