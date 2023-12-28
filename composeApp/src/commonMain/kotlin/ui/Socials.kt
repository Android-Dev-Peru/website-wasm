package ui

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.layout.*
import models.Social
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun Socials(socials: List<Social>) {
    Spacer(Modifier.height(16.dp))
    Row(horizontalArrangement = Arrangement.Center) {
        socials.forEach {
            Box(Modifier.size(56.dp), contentAlignment = Alignment.TopCenter) {
                val interactionSource = remember { MutableInteractionSource() }
                val isHovered = interactionSource.collectIsHoveredAsState()

                val size = animateDpAsState(
                    targetValue = if(isHovered.value) 30.dp else 28.dp
                )

                Image(
                    painter = painterResource(it.icon),
                    contentDescription = null,
                    modifier = Modifier.size(size.value).hoverable(interactionSource),
                    contentScale = ContentScale.Inside,
                )
            }
        }

    }
}