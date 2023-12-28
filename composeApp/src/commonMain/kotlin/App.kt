import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import models.Element
import models.elements
import models.socials
import ui.AndroidTheme
import ui.Header
import ui.Link
import ui.Socials

@Composable
fun App() {
    AndroidTheme {
        Surface(Modifier.fillMaxSize()) {
            Box(modifier = Modifier.fillMaxSize().wrapContentWidth()) {
                MainContent(modifier = Modifier
                    .widthIn(max = 640.dp)
                )
            }
        }
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    LazyColumn(
        contentPadding = PaddingValues(top = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {
        item(key = "header") {
            Header()
        }
        item(key = "socials") {
            Socials(socials)
        }
        elements.forEach {
            when(it) {
                is Element.Section -> {
                    item(key = it.title, contentType = "section-title") {
                        Text(
                            text = it.title,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
                }
                is Element.Link -> {
                    item(key = it.url, contentType = "link") {
                        Link(
                            title = it.title,
                            icon = it.icon,
                            chevronVisibility = it.chevronVisible,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
                }
            }
        }
    }
}
