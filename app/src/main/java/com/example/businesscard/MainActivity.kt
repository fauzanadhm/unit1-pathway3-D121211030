package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Page(name = "A. Fauzan Adhima", title = "Kotlin Novice", phone = "+6282187964646", socialMedia = "@fauzanadh.ma", email = "fauzanadhimaandi@gmail.com")
                }
            }
        }
    }
}

@Composable
fun TopBlock(name: String, title: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.android_logo)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = image, contentDescription = "Android Logo", modifier = modifier.size(128.dp))
        Text(
            text = name,
            fontSize = 40.sp,
            color = Color.White,
            modifier = modifier
        )
        Text(
            text = title,
            fontSize = 20.sp,
            color = Color.White,
            modifier = modifier
        )
    }

}

@Composable
fun BottomBlock(phone: String, socialMedia: String, email: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Row {
            Image(painter = painterResource(id = R.drawable.icons8_phone_50), contentDescription = "phone", modifier = modifier.size(24.dp))
            Spacer(modifier = Modifier.size(36.dp))
            Text(text = phone, color = Color.White)
        }
        Row(
            horizontalArrangement = Arrangement.Center,
        ) {
            Image(painter = painterResource(id = R.drawable.icons8_share_50), contentDescription = "social media", modifier = modifier.size(24.dp))
            Spacer(modifier = Modifier.size(36.dp))
            Text(text = socialMedia, color = Color.White)
        }
        Row(
            horizontalArrangement = Arrangement.Center,
        ) {
            Image(painter = painterResource(id = R.drawable.icons8_email_50), contentDescription = "email", modifier = modifier.size(24.dp))
            Spacer(modifier = Modifier.size(36.dp))
            Text(text = email, color = Color.White)
        }
    }
}

@Composable
fun Page(name: String, title: String, phone: String, socialMedia: String, email: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.background(Color.Black)
    ) {
        TopBlock(name = name, title = title)
        Spacer(modifier = Modifier.size(32.dp))
        BottomBlock(phone = phone, socialMedia = socialMedia, email = email)
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Page(name = "A. Fauzan Adhima", title = "Kotlin Novice", phone = "+6282187964646", socialMedia = "@fauzanadh.ma", email = "fauzanadhimaandi@gmail.com", modifier = Modifier.fillMaxSize())
    }
}