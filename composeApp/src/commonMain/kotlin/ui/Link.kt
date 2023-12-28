package ui

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


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

    val padding = animateDpAsState(
        targetValue = if(isHovered.value) 6.dp else 8.dp,
        animationSpec = if (isHovered.value) keyframes {
            durationMillis = 200
            8.dp at 0
            4.dp at 100
            6.dp at 200
        } else spring()
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(76.dp),
        contentAlignment = Alignment.Center,
        ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding.value)
                .clip(RoundedCornerShape(30.dp))
                .background(MaterialTheme.colors.background)
                .hoverable(interactionSource)
        ) {
            icon?.let {
                Spacer(Modifier.width(8.dp))
                Image(
                    painter = painterResource(icon),
                    contentDescription = null,
                    modifier = Modifier.size(42.dp).clip(CircleShape)
                )
            }
            Text(
                text = title,
                style = MaterialTheme.typography.h2,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
            if (chevronVisibility) {
                Icon(Icons.Default.Check, contentDescription = null)
            }
        }
    }

}