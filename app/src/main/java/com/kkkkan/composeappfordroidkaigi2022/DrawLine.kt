package com.kkkkan.composeappfordroidkaigi2022

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DrawLineCanvasView() {
    val px50toDp = 50f / LocalContext.current.resources.displayMetrics.density
    Canvas(
        modifier = Modifier
            .padding(px50toDp.dp)
            .fillMaxSize()
    ) {
        drawRect(Color.Cyan)
        drawLine(
            color = Color.Red,
            cap = StrokeCap.Square, // 端点にキャップをするイメージ
            start = Offset(50f, 0f),
            end = Offset(800f, 0f),
            strokeWidth = 60f,
        )

        drawLine(
            color = Color.Black,
            cap = StrokeCap.Butt,// そのまま端点処理せず終わるイメージ
            start = Offset(50f, 100f),
            end = Offset(800f, 100f),
            strokeWidth = 60f,
        )

        drawLine(
            color = Color.Red,
            cap = StrokeCap.Round,// 端点を丸くする
            start = Offset(50f, 200f),
            end = Offset(800f, 200f),
            strokeWidth = 60f,
            pathEffect = PathEffect.dashPathEffect(
                FloatArray(4).apply {
                    // インターバルパターン
                    set(0, 60f) // 線
                    set(1, 600f) // 描写なし
                    set(2, 100f) // 線
                    set(3, 70f) // 描写なし
                }, 0f // インターバルパターンのスタート地点のオフセット
            )
        )

        drawLine(
            color = Color.Black,
            cap = StrokeCap.Square,
            start = Offset(50f, 300f),
            end = Offset(800f, 300f),
            strokeWidth = 60f,
            pathEffect = PathEffect.dashPathEffect(
                FloatArray(4).apply {
                    // インターバルパターン
                    set(0, 60f) // 線
                    set(1, 600f) // 描写なし
                    set(2, 100f) // 線
                    set(3, 70f) // 描写なし
                }, 50f // インターバルパターンのスタート地点のオフセット
            )
        )
        drawLine(
            color = Color.Red,
            cap = StrokeCap.Round,
            start = Offset(50f, 400f),
            end = Offset(800f, 400f),
            strokeWidth = 60f,
            pathEffect = PathEffect.dashPathEffect(
                FloatArray(4).apply {
                    // インターバルパターン
                    set(0, 60f) // 線
                    set(1, 600f) // 描写なし
                    set(2, 100f) // 線
                    set(3, 70f) // 描写なし
                }, 840f // インターバルパターンのスタート地点のオフセット
            )
        )

        drawLine(
            color = Color.Black,
            cap = StrokeCap.Square,
            start = Offset(50f, 500f),
            end = Offset(800f, 500f),
            strokeWidth = 60f,
            pathEffect = PathEffect.stampedPathEffect(Path().apply {
                moveTo(0f, 0f)
                lineTo(40f, 40f)
                lineTo(100f, 40f)
            }, 100f, 0f, StampedPathEffectStyle.Translate)
        )

        drawLine(
            brush = Brush.linearGradient(colors = arrayListOf(Color.Red, Color.Blue)),
            cap = StrokeCap.Butt,
            start = Offset(50f, 600f),
            end = Offset(800f, 1600f),
            strokeWidth = 60f,
        )
        drawLine(
            brush = Brush.linearGradient(colors = arrayListOf(Color.Red, Color.Blue)),
            cap = StrokeCap.Butt,
            start = Offset(50f, 800f),
            end = Offset(800f, 1800f),
            strokeWidth = 60f,
        )


    }

}


@Preview(name = "PIXEL_4", device = Devices.PIXEL_4)
@Composable
fun PreviewDrawLineCanvasView() {
    DrawLineCanvasView()
}