package com.kkkkan.composeappfordroidkaigi2022

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DrawArcCanvasView() {
    val px50toDp = 50f / LocalContext.current.resources.displayMetrics.density
    Column(
        modifier = Modifier
            .padding(px50toDp.dp)
            .fillMaxSize()
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(bottom = px50toDp.dp)
        ) {
            drawRect(Color.Cyan)
            drawArc(
                brush = Brush.sweepGradient(colors = arrayListOf(Color.Red, Color.Blue)),
                useCenter = true,
                startAngle = 0f,
                sweepAngle = 270f,
                topLeft = Offset(100f, 50f),
                size = Size(200f, 800f),
            )
            drawArc(
                brush = Brush.sweepGradient(colors = arrayListOf(Color.Red, Color.Blue)),
                useCenter = true,
                startAngle = 0f,
                sweepAngle = 270f,
                topLeft = Offset(350f, 50f),
            )
        }
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            drawRect(Color.Cyan)
            drawArc(
                color = Color.Black,
                startAngle = 0f,
                sweepAngle = 90f,
                useCenter = false,
            )
        }
    }

}


@Preview(name = "PIXEL_4", device = Devices.PIXEL_4)
@Composable
fun PreviewDrawArcCanvasView() {
    DrawArcCanvasView()
}