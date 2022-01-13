package com.zuh.learncompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zuh.learncompose.ui.theme.LearnComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserCard()
        }
    }
}

@Composable
fun UserCard() {
    Row(
        modifier = Modifier.fillMaxWidth().wrapContentHeight()
            .padding(12.dp)
            .border(1.dp, color = Color.Gray)
            .padding(12.dp)
    ) {
        // alt + enter to open option to put params in separate line
        Image(
            painter = painterResource(id = R.drawable.ic_account_box_24),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
        )
        Column {
            Text(
                text = stringResource(id = R.string.dummy_text),
                color = Color.White
            )
            Button(onClick = { /*TODO*/ }) {
                Text(text = "View Profile")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.Black) {
        UserCard()
    }
}