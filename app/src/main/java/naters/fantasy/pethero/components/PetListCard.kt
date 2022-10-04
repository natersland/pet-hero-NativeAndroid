package naters.fantasy.pethero.components

import android.annotation.SuppressLint
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import naters.fantasy.pethero.model.PetData
import naters.fantasy.pethero.model.PetType

@Composable
fun PetListCard(paddingValues: PaddingValues, scrollState: ScrollState) {
    Box(modifier = Modifier.fillMaxSize()) {

    }

}

@Composable
fun PetListCardItem(petData: PetData, modifier: Modifier = Modifier) {
    Card(backgroundColor = Color.White, shape = RoundedCornerShape(10.dp)) {

    }
}


@SuppressLint("UnrememberedMutableState")
@Preview
@Composable

fun PetListCardItemPreview() {
    PetListCardItem(
        petData = PetData(
            petType = PetType.cat,
            petName = "Kopiko",
            petAge = 11,
            petGender = "female",
            petBirthDate = 23,
            aboutPet = "asdsadasdadadasd",
            lovePoint = 99,
            humanAge = "70 ปี")
    )
}
