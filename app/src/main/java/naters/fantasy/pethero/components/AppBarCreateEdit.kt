package naters.fantasy.pethero.components

import android.annotation.SuppressLint
import android.content.Intent.ShortcutIconResource
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import naters.fantasy.pethero.R

@Composable
fun AppBarCreateEdit(headerText: String) {
    TopAppBar(
        contentPadding = PaddingValues(),
        backgroundColor = colorResource(id = R.color.yellow_brand),
        modifier = Modifier
            .height(76.dp)
            .graphicsLayer {
                shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
                clip = true
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(16.dp)

        ) {
            CircularButton(iconResource = R.drawable.ic_baseline_arrow_back_ios_new_24)
            Text(
                text = headerText,
                style = TextStyle(
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,

                    ),
                modifier = Modifier.padding(start = 16.dp), textAlign = TextAlign.Center
            )

        }


    }
}


@Composable
fun CircularButton(
    @DrawableRes iconResource: Int,
    color: Color = Color.Black,
    elevation: ButtonElevation = ButtonDefaults.elevation(), onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = color
        ),
        elevation = elevation,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .width(40.dp)
            .height(40.dp)
    ) {
        Icon(painter = painterResource(id = iconResource), contentDescription = null)
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun AppBarUIPreview(){
    AppBarCreateEdit("แก้ไขสัตว์เลี้ยง")
}