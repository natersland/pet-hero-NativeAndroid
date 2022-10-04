package naters.fantasy.pethero.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import naters.fantasy.pethero.R
import naters.fantasy.pethero.Screen


@Composable
fun PetHeroFab(navController: NavController) {
    FloatingActionButton(
        onClick = {
            navController.navigate(route = Screen.EditPet.route)
        },
        backgroundColor = colorResource(id = R.color.blue_brand)
    ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Add", tint = Color.White)
    }
}