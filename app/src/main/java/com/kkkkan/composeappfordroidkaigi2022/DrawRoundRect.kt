package com.kkkkan.composeappfordroidkaigi2022

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * drawRoundRect の例
 */
@Composable
fun DrawRoundRectCanvasView() {
    val px50toDp = 50f / LocalContext.current.resources.displayMetrics.density

    Canvas(
        modifier = Modifier
            .padding(px50toDp.dp)
            .fillMaxSize()
    ) {
        drawRect(Color.Cyan)

        // 赤、角は縦軸半径180横軸半径180の楕円
        drawRoundRect(
            color = Color.Red,
            topLeft = Offset(100f, 100f),
            size = Size(500f, 300f),
            cornerRadius = CornerRadius(180f, 180f),
        )

        // 赤、角は縦軸半径180横軸半径180の楕円、
        // 透過度0.5、カラーフィルター有
        drawRoundRect(
            color = Color.Red,
            topLeft = Offset(100f, 500f),
            size = Size(500f, 300f),
            cornerRadius = CornerRadius(180f, 180f),
            alpha = 0.5f,
            colorFilter = ColorFilter.tint(Color.Green, BlendMode.DstOver)
        )

        // 赤→青→赤のグラデーション、角は縦軸半径90横軸半径90の楕円、
        drawRoundRect(
            brush = Brush.linearGradient(
                colors = arrayListOf(Color.Red, Color.Blue, Color.Red),
                start = Offset(100f, 900f),
                end = Offset(100f, 1400f)
            ),
            topLeft = Offset(100f, 900f),
            size = Size(500f, 500f),
            cornerRadius = CornerRadius(90f, 90f),
        )

        // 赤→青→赤のグラデーション、角は縦軸半径90横軸半径90の楕円
        // 描くのは外周のみ 10 pixel
        drawRoundRect(
            brush = Brush.linearGradient(
                colors = arrayListOf(Color.Red, Color.Blue, Color.Red),
                start = Offset(100f, 1500f),
                end = Offset(100f, 2000f)
            ),
            topLeft = Offset(100f, 1500f),
            size = Size(500f, 500f),
            cornerRadius = CornerRadius(90f, 90f),
            style = Stroke(10f)
        )

    }


}


@Preview(name = "PIXEL_4", device = Devices.PIXEL_4)
@Composable
fun PreviewDrawRoundRectCanvasView() {
    DrawRoundRectCanvasView()
}