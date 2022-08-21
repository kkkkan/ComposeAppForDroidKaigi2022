package com.kkkkan.composeappfordroidkaigi2022

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DrawRectCanvasView() {
    val px50toDp = 50f / LocalContext.current.resources.displayMetrics.density

    Canvas(
        modifier = Modifier
            .padding(px50toDp.dp)
            .fillMaxSize()
    ) {
        drawRect(Color.Cyan)

        drawRect(
            brush = Brush.linearGradient(
                colors = arrayListOf(Color.Red, Color.Green),
                end = Offset(600f, 500f),
                start = Offset(100f, 100f)
            ),
            topLeft = Offset(100f, 100f),
            size = Size(500f, 400f)

        )

        drawRect(
            color = Color.Black,
            topLeft = Offset(300f, 600f),
            size = Size(500f, 400f),
            style = Stroke(width = 20f)
        )

        drawRect(
            color = Color.Black,
            topLeft = Offset(100f, 1100f),
            size = Size(500f, 400f),
            alpha = 0.5f
        )
    }


}


@Preview(name = "PIXEL_4", device = Devices.PIXEL_4)
@Composable
fun PreviewDrawRectCanvasView() {
    DrawRectCanvasView()
}