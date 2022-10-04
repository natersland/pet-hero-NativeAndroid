package naters.fantasy.pethero.components

import android.annotation.SuppressLint
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import naters.fantasy.pethero.R
import naters.fantasy.pethero.model.BottomMenuData

@Composable
fun BottomMenu() {
    val items = listOf(
        BottomMenuData.Home,
        BottomMenuData.PetList,
        BottomMenuData.Setting
    )

    BottomNavigation(
        backgroundColor = colorResource(id = R.color.blue_brand),
        contentColor = Color.White,
        modifier = Modifier.graphicsLayer {
            shape = RoundedCornerShape(topEnd = 15.dp, topStart = 15.dp)
            clip = true
        }, elevation = 16.dp) {
        items.forEach {
            BottomNavigationItem(
                label = { Text(text = it.title) },
                alwaysShowLabel = true,
                selected = false,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = it.title
                    )
                })
        }

    }
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun BottomMenuPreview(){
    BottomMenu()
}