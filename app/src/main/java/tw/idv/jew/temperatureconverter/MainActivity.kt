package tw.idv.jew.temperatureconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {  //使用Compose需改繼承ComponentActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityContent()
        }
    }
}

@Composable
fun Header(image: Int, description: String) {
    Image(  //使用Image composable
        painter = painterResource(image),  //指定圖像
        contentDescription = description,    //圖像的敘述
        modifier = Modifier //可用來加入額外類別
            .height(180.dp)
            .fillMaxWidth(),
        contentScale = ContentScale.Crop    //自動縮放圖像
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterTemperature(temperature: String, changed: (String) -> Unit) {
    TextField(
        value = temperature,
        label = { Text("Enter a temperature in Celsius") }, //讓TextField的label使用這段文字
        onValueChange = changed,    //當用戶更改TextField時，執行指定的lambda
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun ConvertButton(clicked: () -> Unit) {
    Button(onClick = clicked) {
        Text("Convert")
    }
}

@Composable
fun TemperatureText(celsius: Int) { //顯示攝氏轉換成華氏的文字
    val fahrenheit = (celsius.toDouble()*9/5)+32
    Text("$celsius Celsius is $fahrenheit Fahrenheit")
}

//這個註解會將它轉換成composable函式
@Composable
fun MainActivityContent() {
    //使用remeber將物件存入composable的記憶體
    val celsius = remember { mutableStateOf(0) }

    Column {
        Header(R.drawable.sunrise, "sunrise image")
        ConvertButton { celsius.value = 20 }
        TemperatureText(celsius.value)  //Compose只會在接收引數改變時重繪
    }
}

//預覽（只有沒有引數的composable函式）：只有加入此註解的片段程式能使用Split或Design預覽
@Preview(showBackground = true) //預設背景是透明的，所以使用showBackground = true覆寫設定
@Composable
fun PreviewMainActivity() { //要及時預覽的部分（Preview+類別名稱）程式碼因該要相同
    MainActivityContent()
}