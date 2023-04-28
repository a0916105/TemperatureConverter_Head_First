package tw.idv.jew.temperatureconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

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

//預覽（只有沒有引數的composable函式）：只有加入此註解的片段程式能使用Split或Design預覽
@Preview(showBackground = true) //預設背景是透明的，所以使用showBackground = true覆寫設定
@Composable
fun PreviewMainActivity() { //要及時預覽的部分（Preview+類別名稱）程式碼因該要相同
    Column {    //使用Column排列方式
        //使用composable函式
        Hello("friend")
        Hello("everyone")
    }
}