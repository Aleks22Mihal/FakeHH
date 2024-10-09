package effectivemobile.aleksey.fakehh.fetures.vacancy

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import effectivemobile.aleksey.fakehh.common.ui.R
import effectivemobile.aleksey.fakehh.common.ui.components.FakeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun VacancyScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.icon_arrow_back_24dp),
                            contentDescription = stringResource(R.string.back)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                ),
                windowInsets = WindowInsets(0.dp)
            )
        },
    ) { scaffoldPadding ->
        FakeScreen(
            R.string.vacancy,
            modifier = Modifier.padding(scaffoldPadding)
        )
    }
}