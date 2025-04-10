package com.example.greetingcard

import android.graphics.Color.blue
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.greetingcard.ui.theme.GreetingCardTheme
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "screen1") {
        composable("screen1") { Screen1(navController) }
        composable("screen2") { Screen2(navController) }
        composable("screen3") { Screen3(navController) }
    }
}

@Composable
fun Screen1(navController: NavController) {
    val image = painterResource(R.drawable.image_1) // Ensure this resource exists
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .width(250.dp)
                .height(250.dp)
                .padding(bottom = 20.dp)
        )
        Text(
            text = "Jetpack Compose",
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            modifier = Modifier.padding(bottom = 8.dp),
        )
        Text(
            text = "Jetpack Compose is a modern UI toolkit for building native Android applications using a declarative programming approach.",
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 8.dp)
        )

        Button(
            onClick = { navController.navigate("screen2") },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(top = 24.dp)
        ) {
            Text(
                text = "I'm ready",
                fontSize = 18.sp
            )
        }
    }
}

@Composable
fun Screen2(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "UI Components List",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
            color = Color.Blue,
        )
        Spacer(modifier = Modifier.height(16.dp))

        SectionTitle("Display")
        ComponentItem("Text","Displays text" ,navController)

        ComponentItem("Image","Displays an image", navController)

        SectionTitle("Input")
        ComponentItem("TextField","Input field for text", navController)
        ComponentItem("PasswordField","Input field for passwords", navController)

        SectionTitle("Layout")
        ComponentItem("Column","Arranges elements vertically", navController)
        ComponentItem("Row","Arranges elements horizontally", navController)

    }
}

@Composable
fun Screen3(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // Nút quay lại
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                 navController.popBackStack()})

             {
                Text("Back")
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Text Detail",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(16.dp))
        TextDetail()
    }
}
@Composable
fun TextDetail() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = buildAnnotatedString {
                append("The ")
                withStyle(style = SpanStyle(textDecoration = TextDecoration.LineThrough)) {
                    append("quick")
                }


                withStyle(style = SpanStyle(color = Color(0xFF8B4513), fontWeight = FontWeight.Bold)) {
                    append("Brown ")
                }
                append("\n")
                append(" fox jumps")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("over ")
                }
                append("\n")

                withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                    append("the ")
                }
                withStyle(style = SpanStyle(fontStyle = FontStyle.Italic)) {
                    append("lazy")
                }
                append(" dog.")
            },
            fontSize = 32.sp,
            lineHeight = 40.sp,
            modifier = Modifier.padding(16.dp),

        )
    }

}
@Composable
fun SectionTitle(title: String){
    Text(
        text = title,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(top=12.dp, bottom=8.dp).fillMaxWidth().wrapContentWidth(Alignment.Start)

    )
}

@Composable
fun ComponentItem(title:String, descripton:String, navController: NavController) {
    Column(
        modifier = Modifier.fillMaxWidth().background(Color(0xFFD6EAF8)).clip(RoundedCornerShape(16.dp)).padding(12.dp).padding(horizontal = 16.dp).clickable{if(title == "Text"){
            navController.navigate("screen3")
        } }
    ) {
        Text(text=title, fontWeight = FontWeight.Bold)
        Text(text=descripton, fontSize = 14.sp)
    }
    Spacer(modifier = Modifier.height(8.dp))
}