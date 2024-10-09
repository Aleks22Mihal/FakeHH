package effectivemobile.aleksey.fakehh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import effectivemobile.aleksey.fakehh.common.ui.theme.FakeHHTheme
import effectivemobile.aleksey.fakehh.navigation.AppNavHost
import effectivemobile.aleksey.fakehh.navigation.NavBottomBarView

@AndroidEntryPoint
internal class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            val mainViewModel = hiltViewModel<MainViewModel>()
            val navController = rememberNavController()
            val itemCountInFavorite by mainViewModel.itemCountInFavoriteCollection.collectAsStateWithLifecycle()

            FakeHHTheme {
                Scaffold(
                    bottomBar = {
                        NavBottomBarView(
                            navController = navController,
                            itemCountInFavorite = itemCountInFavorite
                        )
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    AppNavHost(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}