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

/**
 * drawOval の例
 */
@Composable
fun DrawOvalCanvasView() {
    val px50toDp = 50f / LocalContext.current.resources.displayMetrics.density
    Canvas(
        modifier = Modifier
            .padding(px50toDp.dp)
            .fillMaxSize()
    ) {
        drawRect(Color.Cyan)
        // 左上に描く
        drawOval(
            brush = Brush.sweepGradient(colors = arrayListOf(Color.Red, Color.Blue)),
            size = Size(300f, 500f)
        )

        // 右にずらして描く
        drawOval(
            color = Color.Red,
            topLeft = Offset(300f, 0f),
            size = Size(300f, 500f),
        )


        // 下にずらして描く
        drawOval(
            brush = Brush.sweepGradient(colors = arrayListOf(Color.Red, Color.Blue)),
            topLeft = Offset(0f, 550f),
            size = Size(300f, 500f),
        )

        // 右下にずらして残りの領域を埋めるように描く
        drawOval(
            color = Color.Black,
            style = Stroke(30f),
            topLeft = Offset(350f, 550f),
        )
        drawLine(
            color = Color.Black,
            start = Offset(300f, 0f),
            end = Offset(300f, 1050f),
            strokeWidth = 10f
        )
        drawLine(
            color = Color.Black,
            start = Offset(0f, 500f),
            end = Offset(650f, 500f),
            strokeWidth = 10f
        )
    }

}


@Preview(name = "PIXEL_4", device = Devices.PIXEL_4)
@Composable
fun PreviewDrawOvalCanvasView() {
    DrawOvalCanvasView()
}