package com.kkkkan.composeappfordroidkaigi2022

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InsetCanvasView() {
    val px50toDp = 50f / LocalContext.current.resources.displayMetrics.density
    Canvas(
        modifier = Modifier
            .padding(px50toDp.dp)
            .fillMaxSize()
    ) {
        drawRect(Color.Cyan)
        val height = size.height

        // 何もしない場合
        // 左端に上端から下端までの黒い線を引く
        drawLine(
            color = Color.Black,
            start = Offset.Zero,
            end = Offset(0f, height),
            strokeWidth = 20f,
        )

        // insetを設定する
        inset(left = 100f, top = 500f, bottom = 0f, right = 0f) {
            // 取り直した領域の左端に上端から下端までの赤い線を引く
            drawLine(
                color = Color.Red,
                start = Offset.Zero,
                end = Offset(0f, this.size.height),
                strokeWidth = 20f,
            )

            // 取り直した領域の右端に上端から下端までの赤い線を引く
            drawLine(
                color = Color.Red,
                start = Offset(this.size.width, 0f),
                end = Offset(this.size.width, this.size.height),
                strokeWidth = 20f,
            )

        }

    }

}


@Preview(name = "PIXEL_4", device = Devices.PIXEL_4)
@Composable
fun PreviewInsetCanvasView() {
    InsetCanvasView()
}