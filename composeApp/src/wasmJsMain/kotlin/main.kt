import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.window.CanvasBasedWindow
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.resource
import ui.DMSans

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow(canvasElementId = "ComposeTarget") {
        App()

        LaunchedEffect(Unit) {
            loadFont()
        }
    }
}

private suspend fun loadFont() {
    val regular = loadResource("DMSans-Regular.ttf")
    val bold = loadResource("DMSans-Bold.ttf")


    DMSans = FontFamily(
        Font("DMSans-Regular", data = regular, weight = FontWeight.Normal),
        Font("DMSans-Bold", data = bold, weight = FontWeight.Bold),
    )
}

@OptIn(ExperimentalResourceApi::class)
internal suspend fun loadResource(resourcePath: String): ByteArray {
    return resource(resourcePath).readBytes()
}