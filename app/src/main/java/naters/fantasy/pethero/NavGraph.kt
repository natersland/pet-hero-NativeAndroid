package naters.fantasy.pethero

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import naters.fantasy.pethero.pages.HomeScreenPage
import androidx.compose.runtime.Composable
import naters.fantasy.pethero.pages.EditPetPage


@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.Home.route){
        composable(
            route = Screen.Home.route
        ){
            HomeScreenPage(navController = navController)
        }
        composable(
            route = Screen.EditPet.route
        ){
            EditPetPage()
        }
    }
}
