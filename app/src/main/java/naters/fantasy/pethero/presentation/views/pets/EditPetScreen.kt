package naters.fantasy.pethero.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import naters.fantasy.pethero.R
import naters.fantasy.pethero.components.AppBarCreateEdit

@Composable
fun EditPetPage() {
    Box {
        Column {
            AppBarCreateEdit("แก้ไขสัตว์เลี้ยง")
            PetAvatar()
            PetDetailForm()

        }
    }
}

@Composable
fun PetAvatar() {
    Spacer(modifier = Modifier.height(50.dp))
    Box() {
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            Card(
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .size(140.dp)

            ) {
                Image(
                    painter = painterResource(id = R.drawable.cat_1),
                    contentDescription = "Pet Avatar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(25.dp))
}

@Composable
fun PetDetailForm() {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
        Text(
            text = "ชื่อ",
            fontSize = 18.sp,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(8.dp)
        )
        TextField(
            value = "",
            onValueChange = {},
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            placeholder = { Text(text = "ฟักทอง") },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            maxLines = 1
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Column() {
                Text(
                    text = "เพศ",
                    fontSize = 18.sp,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(8.dp)
                )
                Row() {
                    // Just for UI mockup
                    GenderButton("♂")
                    Spacer(modifier = Modifier.width(8.dp))
                    GenderButton("♀")
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column() {
                Text(
                    text = "วันเกิด",
                    fontSize = 18.sp,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(8.dp)
                )
                TextField(
                    value = "",
                    onValueChange = {},
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier.padding(8.dp),
                    placeholder = { Text(text = "22/09/2022") },
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    trailingIcon = {
                        Icon(imageVector = Icons.Default.DateRange, contentDescription = null)
                    },
                    maxLines = 1
                )
            }
        }
        Text(
            text = "เกี่ยวกับฉัน",
            fontSize = 18.sp,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(8.dp)
        )
        TextField(
            value = "",
            onValueChange = {},
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            placeholder = { Text(text = "เวลาว่างชอบดูโดเรม่อน") },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
        SubmitButton("แก้ไขสัตว์เลี้ยง", colorResource(id = R.color.yellow_brand))
    }
}

@Composable
fun SubmitButton(text: String, backgroundColor: Color, onClick: () -> Unit = {}) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        )
    } }

@Composable
fun GenderButton(gender: String) {
    Button(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(100.dp),
        modifier = Modifier
            .size(50.dp),
        colors = when (gender) {
            "♀" -> ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.pink_brand))
            else -> ButtonDefaults.buttonColors(backgroundColor = Color.White)
        },
        elevation = ButtonDefaults.elevation(
            defaultElevation = 2.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp
        ),

        ) {
        Text(
            text = gender,
            style = TextStyle(
                color = when (gender) {
                    "♀" -> colorResource(id = R.color.white)
                    else -> colorResource(id = R.color.blue_brand)
                },
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
        )
    }
}
