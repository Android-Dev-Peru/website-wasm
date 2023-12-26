import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

sealed interface Element {
    data class Section(val title: String): Element
    data class Link(
        val title: String,
        val url: String,
        val icon: String? = null,
        val chevronVisible: Boolean = false
    ): Element
    
    data class Custom(val key: String, val content: @Composable () -> Unit): Element
}

val elements: List<Element> = listOf(
    Element.Link(title = "Resultados de encuesta salarial", icon = "", url = "fasdfasfasfs"),
    Element.Link(title = "Llena la encuesta salarial aqui", icon = "", url = "fasdfasdf"),
    
    Element.Section(title = "Último meetup"),
    Element.Link(title = "Meetup #57 KMP stable", icon = "colored_youtube.png", url = "fasfas"),
    Element.Link(title = "Meetup #57", icon = "colored_twitter.png", url = "https://twitter.com/androiddevperu/status/1727862022287589605"),

    Element.Section(title = "Comunidad"),
    Element.Link(title = "Únete a nuestra comunidad en WhatsApp", icon = "colored_wsp", url = "https://chat.whatsapp.com/Il7yhDYCj8zLVDrK7OpFOm"),

    Element.Section(title = "Eventos pasados"),
    Element.Link(title = "Checa todo nuestro contenido posteado", icon = "", url = "https://dev.to/androiddevperu"),
)

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
            Socials()
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
                is Element.Custom -> {
                    item(it.key) {
                        it.content
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun Header() {
    Image(
        painter = painterResource("android_logo.png"),
        contentDescription = "Android Dev Peru logo",
        modifier = Modifier.size(96.dp),
    )
    Text(
        text = "Android Dev Perú",
        fontWeight = FontWeight.ExtraBold,
        modifier = Modifier.padding(top = 16.dp)
    )
    Text(text = "Comunidad de Android en Perú", Modifier.padding(12.dp))
}

@Composable
fun Socials() {
    
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun Link(
    title: String,
    modifier: Modifier = Modifier,
    icon: String? = null,
    chevronVisibility: Boolean = true
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered = interactionSource.collectIsHoveredAsState()
    
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(if (isHovered.value) Color.DarkGray else AndroidColors.background)
            .hoverable(interactionSource)
            .padding(8.dp)
    ) {
        icon?.let {
            Image(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.size(42.dp).clip(CircleShape)
            )
        }
        Text(title, textAlign = TextAlign.Center, modifier = Modifier.weight(1f))  
        if (chevronVisibility) {
            Icon(Icons.Default.Check, contentDescription = null)  
        }
    }
}
val AndroidColors = lightColors(
    surface = Color(0xFFF4FDF4),
    background = Color(0xFFA6EB99)
)

@Composable
fun AndroidTheme(content: @Composable () -> Unit) {
    MaterialTheme(colors = AndroidColors, content = content)
}