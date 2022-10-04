package naters.fantasy.pethero.components

import android.annotation.SuppressLint
import android.app.AlertDialog
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import naters.fantasy.pethero.R

@Composable
fun AccountDialog(openDialog: MutableState<Boolean>) {
    Dialog(onDismissRequest = { openDialog.value = false },
    properties = DialogProperties(dismissOnClickOutside = false)
    ) {
        AccountDialogUI(openDialog = openDialog)
    }
}


@Composable
fun AccountDialogUI(modifier: Modifier = Modifier, openDialog: MutableState<Boolean>) {
    Card(shape = RoundedCornerShape(15.dp)) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(bottom = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { openDialog.value = false}) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = null)
                }
                Text(
                    text = "บัญชีของฉัน", modifier = Modifier
                        .weight(2.0f), style = TextStyle(fontWeight = FontWeight.Bold)
                )

            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.danilo),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(
                            CircleShape
                        )
                        .size(30.dp)
                        .background(Color.Gray)
                )
                Column(
                    modifier = Modifier
                        .weight(2.0f)
                        .padding(start = 16.dp)
                ) {
                    Text(
                        text = "ชื่อผู้ใช้",
                        style = TextStyle(fontWeight = FontWeight.Bold),
                        fontSize = 15.sp
                    )
                    Text(
                        text = "pethero@mail.com",
                        fontSize = 15.sp
                    )
                }
                Text(
                    text = "Lv.1",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.blue_brand)
                    ),
                    fontSize = 15.sp
                )

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 16.dp), horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.blue_brand)),

                    ) {
                    Text(text = "ออกจากระบบ", color = Color.White)
                }

            }

        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun AccountDialogUIPreview(){
    AccountDialogUI(openDialog = mutableStateOf(false))
}