package com.kkkkan.composeappfordroidkaigi2022

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * drawPath の例
 */
@Composable
fun DrawPathCanvasView() {
    val px50toDp = 50f / LocalContext.current.resources.displayMetrics.density
    Canvas(
        modifier = Modifier
            .padding(px50toDp.dp)
            .fillMaxSize()
    ) {
        drawRect(Color.Cyan)

        val path1 = Path()
        path1.addRect(Rect(0f, 100f, 200f, 400f))
        path1.lineTo(400f, 50f)
        drawPath(
            path = path1,
            brush = Brush.linearGradient(
                colors = arrayListOf(Color.Red, Color.Blue),
                end = Offset(200f, 400f)
            ),
            style = Stroke(50f)
        )


        val path2 = Path()
        path2.addOval(Rect(0f, 500f, 200f, 900f))
        path2.lineTo(300f, 1000f)
        path2.lineTo(900f, 500f)
        drawPath(path = path2, color = Color.Black, alpha = 0.6f)

    }

}


@Preview(name = "PIXEL_4", device = Devices.PIXEL_4)
@Composable
fun PreviewDrawPathCanvasView() {
    DrawPathCanvasView()
}