package com.kkkkan.composeappfordroidkaigi2022

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DrawCircleCanvasView() {
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
            drawCircle(
                brush = Brush.sweepGradient(colors = arrayListOf(Color.Red, Color.Blue)),

                )
        }
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            drawRect(Color.Cyan)
            drawCircle(
                color = Color.Black,
                center = Offset(100f, 300f),
                radius = 400f,
                style = Stroke(width = 50f)

            )
            drawCircle(
                brush = Brush.sweepGradient(colors = arrayListOf(Color.Red, Color.Blue)),
                center = Offset(600f, 200f),
                radius = 400f,
                style = Stroke(width = 50f)

            )
        }
    }

}


@Preview(name = "PIXEL_4", device = Devices.PIXEL_4)
@Composable
fun PreviewDrawCircleCanvasView() {
    DrawCircleCanvasView()
}