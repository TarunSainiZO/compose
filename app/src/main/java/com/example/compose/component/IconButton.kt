package com.example.compose.component

import android.graphics.drawable.PaintDrawable
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.R
import com.example.compose.ui.theme.Shapes

@ExperimentalMaterialApi
@Composable
fun IconButton() {
    val text = "Sign Up with Google"
    val loadingText = "Creating account..."
    var clicked by remember {
        mutableStateOf(false)
    }
    Surface(
        onClick = { clicked = !clicked },
        shape = Shapes.medium,
        border = BorderStroke(width = 1.dp,color = Color.LightGray),
        color = MaterialTheme.colors.surface
        ) {
        Row(modifier = Modifier
            .padding(
                start = 12.dp,
                end = 16.dp,
                top = 12.dp,
                bottom = 12.dp
            )
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(modifier = Modifier
                .width(20.dp)
                .height(20.dp),painter = painterResource(id = R.drawable.google), contentDescription ="Google Button",tint = Color.Unspecified )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = if(clicked) loadingText else text)
            if(clicked){
                Spacer(modifier = Modifier.width(5.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .height(16.dp)
                        .width(16.dp),
                    strokeWidth = 2.dp,
                    color = MaterialTheme.colors.primary
                )
            }
        }

    }
}

@ExperimentalMaterialApi
@Composable
@Preview
fun IconButtonPreview() {
    IconButton()
}