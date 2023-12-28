package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

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
        style = MaterialTheme.typography.h1,
        modifier = Modifier.padding(top = 16.dp)
    )
    Text(
        text = "Comunidad de Android en Perú",
        style = MaterialTheme.typography.h2,
        modifier = Modifier.padding(12.dp),
        )
}
