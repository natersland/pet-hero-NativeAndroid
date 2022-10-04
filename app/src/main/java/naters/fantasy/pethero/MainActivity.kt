package naters.fantasy.pethero

import android.accessibilityservice.AccessibilityButtonController
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import naters.fantasy.pethero.components.AppBarMain
import naters.fantasy.pethero.components.BottomMenu
import naters.fantasy.pethero.components.PetHeroFab
import naters.fantasy.pethero.pages.EditPetPage
import naters.fantasy.pethero.pages.HomeScreenPage
import naters.fantasy.pethero.ui.theme.PetHeroTheme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetHeroTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}

@Composable
fun PetHeroApp(navController: NavController) {
    HomeScreenPage(navController = navController)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PetHeroTheme {
        PetHeroApp(navController = rememberNavController())
    }
}