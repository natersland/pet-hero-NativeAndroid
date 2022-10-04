package naters.fantasy.pethero.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import naters.fantasy.pethero.components.AccountDialogUI
import naters.fantasy.pethero.components.AppBarMain
import naters.fantasy.pethero.components.PetHeroFab

@Composable
fun HomeScreenPage(
    navController: NavController
){
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
    val openDialog = remember {
        mutableStateOf(false)
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppBarMain(
                scaffoldState = scaffoldState,
                scope = coroutineScope,
                openDialog = openDialog
            )
        },
//        bottomBar = {
//            BottomMenu()
//        },
        floatingActionButton = {
            PetHeroFab(navController)
        }
    ) {

    }
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreenPage(navController = rememberNavController())
}