package effectivemobile.aleksey.fakehh.features.main.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import effectivemobile.aleksey.fakehh.common.ui.R
import effectivemobile.aleksey.fakehh.features.main.data.MainScreenEvent
import effectivemobile.aleksey.fakehh.features.main.data.MainScreenState

@Composable
internal fun SearchBarView(
    state: MainScreenState,
    onEvent: (MainScreenEvent) -> Unit
) {

    var focusState by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current

    Row(
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .height(40.dp)
            .fillMaxWidth()
    ) {
        BasicTextField(
            value = state.searchText,
            onValueChange = { text ->
                onEvent(MainScreenEvent.ChangeText(text))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            ),
            textStyle = MaterialTheme
                .typography
                .bodyMedium
                .copy(color = Color.White),
            cursorBrush = SolidColor(Color.White),
            singleLine = true,
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            color = MaterialTheme.colorScheme.onBackground,
                            shape = MaterialTheme.shapes.medium
                        )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 8.dp)
                    ) {
                        if (state.isClickButtonMore) {
                            Image(
                                painter = painterResource(R.drawable.icon_arrow_back_24dp),
                                contentDescription = stringResource(R.string.content_description_icon_in_search_bar_back),
                                modifier = Modifier.clickable {
                                    onEvent(MainScreenEvent.ClickButtonMore)
                                }
                            )
                        } else {
                            Image(
                                painter = painterResource(R.drawable.icon_search_24dp),
                                contentDescription = stringResource(R.string.content_description_icon_in_search_bar)
                            )
                        }
                        if (state.searchText.isEmpty() && !focusState) {
                            Text(
                                text = stringResource(R.string.placeholder_text_field_text),
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.surfaceContainerLow
                            )
                        } else {
                            innerTextField()
                        }
                    }
                }
            },
            modifier = Modifier
                .onFocusChanged {
                    if (it.isFocused) {
                        focusState = true
                    } else {
                        focusState = false
                        focusManager.clearFocus()
                    }

                }
                .weight(1f)
        )
        Card(
            onClick = {
                val text = context.getText(R.string.not_a_functional_element)
                Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
            },
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.onBackground
            ),
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.size(40.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(R.drawable.icon_filter_24dp),
                    contentDescription = "",
                )
            }
        }
    }
}