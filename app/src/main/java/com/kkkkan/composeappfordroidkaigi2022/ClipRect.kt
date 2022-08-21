package com.kkkkan.composeappfordroidkaigi2022

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ClipRectCanvasView() {
    val px50toDp = 50f / LocalContext.current.resources.displayMetrics.density
    Canvas(
        modifier = Modifier
            .padding(px50toDp.dp)
            .fillMaxSize()
    ) {
        drawRect(Color.Cyan)
        val height = size.height

        // 何もしない場合 DrawScopeの領域外にも書ける
        drawLine(
            color = Color.Black,
            start = Offset(50f, -50f),
            end = Offset(50f, height + 50f),
            strokeWidth = 10f,
        )

        clipRect {
            // clipRectを使用すると領域外の部分は描写されない
            drawLine(
                color = Color.Red,
                start = Offset(100f, -50f),
                end = Offset(100f, height + 50f),
                strokeWidth = 10f,
            )
        }

        clipRect(top = 500f, bottom = height - 500f) {
            // clipRectする領域を設定することも可能
            drawLine(
                color = Color.Magenta,
                start = Offset(200f, -50f),
                end = Offset(200f, height + 50f),
                strokeWidth = 10f,
            )
        }


        clipRect(top = 500f, bottom = height - 500f, clipOp = ClipOp.Difference) {
            // clipOp = ClipOp.Difference を設定すると指定した領域外の部分のみ描写するようになる
            drawLine(
                color = Color.Gray,
                start = Offset(300f, -50f),
                end = Offset(300f, height + 50f),
                strokeWidth = 10f
            )
        }


    }

}


@Preview(name = "PIXEL_4", device = Devices.PIXEL_4)
@Composable
fun PreviewClipRectCanvasView() {
    ClipRectCanvasView()
}