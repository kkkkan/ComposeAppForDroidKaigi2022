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

/**
 *  clipRect の例
 */
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
        val padding = size.width / 5


        // 何もしない場合 DrawScopeの領域外にも書ける
        drawLine(
            color = Color.Black,
            start = Offset(padding, -50f),
            end = Offset(padding, height + 50f),
            strokeWidth = 20f,
        )

        clipRect {
            // clipRectを使用すると領域外の部分は描写されない
            drawLine(
                color = Color.Red,
                start = Offset(padding * 2, -50f),
                end = Offset(padding * 2, height + 50f),
                strokeWidth = 20f,
            )
        }

        clipRect(top = 500f, bottom = height - 500f) {
            // clipRectする領域を設定することも可能
            drawLine(
                color = Color.Magenta,
                start = Offset(padding * 3, -50f),
                end = Offset(padding * 3, height + 50f),
                strokeWidth = 20f,
            )
        }


        clipRect(top = 500f, bottom = height - 500f, clipOp = ClipOp.Difference) {
            // clipOp = ClipOp.Difference を設定すると指定した領域外の部分のみ描写するようになる
            drawLine(
                color = Color.Gray,
                start = Offset(padding * 4, -50f),
                end = Offset(padding * 4, height + 50f),
                strokeWidth = 20f
            )
        }


    }

}


@Preview(name = "PIXEL_4", device = Devices.PIXEL_4)
@Composable
fun PreviewClipRectCanvasView() {
    ClipRectCanvasView()
}