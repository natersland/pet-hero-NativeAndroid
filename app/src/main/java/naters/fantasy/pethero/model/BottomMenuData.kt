package naters.fantasy.pethero.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomMenuData(
    val icon: ImageVector,
    val title: String
) {
    object Home: BottomMenuData(icon = Icons.Outlined.Home, title = "Home")
    object PetList: BottomMenuData(icon = Icons.Outlined.Add, title = "Pet List")
    object Setting: BottomMenuData(icon = Icons.Outlined.Settings, title = "Setting")
}
