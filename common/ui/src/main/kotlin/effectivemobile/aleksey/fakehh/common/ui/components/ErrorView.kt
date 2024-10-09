package effectivemobile.aleksey.fakehh.common.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import effectivemobile.aleksey.fakehh.common.ui.R

@Composable
fun ErrorView(
    modifier: Modifier = Modifier,
    onClickForRefresh: () -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Button(
            onClick = {
                onClickForRefresh()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(
                text = stringResource(R.string.try_again),
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}