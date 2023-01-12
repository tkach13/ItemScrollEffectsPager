package ge.tkach13.ItemScrollEffects

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import ge.tkach13.ItemScrollEffects.ui.cubeOutTransformer
import ge.tkach13.ItemScrollEffects.ui.theme.ItemScrollEffectDemoTheme
import kotlin.math.absoluteValue

@OptIn(ExperimentalPagerApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ItemScrollEffectDemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    HorizontalPager(count = 5) { page->

                        Box(
                            modifier = Modifier
                                .cubeOutTransformer(page, this)
                                .fillMaxSize()

                                .background(
                                    color = when (page) {
                                        1 -> Color.Red
                                        2 -> Color.Gray
                                        3 -> Color.Yellow
                                        4 -> Color.Green
                                        else -> Color.Blue
                                    }
                                ),
                            contentAlignment = Alignment.Center

                        ) {
                            Text(
                                text = page.toString(),
                                fontSize = 64.sp
                            )

                        }
                    }
                }


            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ItemScrollEffectDemoTheme {
        Greeting("Android")
    }
}