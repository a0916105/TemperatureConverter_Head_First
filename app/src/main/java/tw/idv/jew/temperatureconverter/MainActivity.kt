package tw.idv.jew.temperatureconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class MainActivity : ComponentActivity() {  //使用Compose需改繼承ComponentActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {    //使用Column排列方式
                //使用composable函式
                Hello("friend")
                Hello("everyone")
            }
        }
    }
}

//這個註解會將它轉換成composable函式
@Composable
fun Hello(name: String) {
    Text("Hello $name! Welcome to Jetpack Compose")
}