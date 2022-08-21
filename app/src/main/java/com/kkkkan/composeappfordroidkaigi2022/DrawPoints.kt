package com.kkkkan.composeappfordroidkaigi2022

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
fun DrawPointsCanvasView() {
    val px50toDp = 50f / LocalContext.current.resources.displayMetrics.density
    Column(
        modifier = Modifier
            .padding(px50toDp.dp)
            .fillMaxSize()
    ) {
        val points = ArrayList<Offset>().apply {
            add(Offset(100f, 20f))
            add(Offset(400f, 100f))
            add(Offset(100f, 90f))
            add(Offset(100f, 120f))
        }

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(bottom = px50toDp.dp)
        ) {
            drawRect(Color.Cyan)

            // 点として描く
            drawPoints(
                points = points,
                pointMode = PointMode.Points,
                color = Color.Black,
                strokeWidth = 20f,
                cap = StrokeCap.Round // 丸い点にする
            )

        }

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(bottom = px50toDp.dp)
        ) {
            drawRect(Color.Cyan)


            // 2点ずつつなげる
            // 点の数が奇数の時は最後の点は描写に反映されない
            drawPoints(
                points = points,
                pointMode = PointMode.Lines,
                brush = Brush.linearGradient(
                    colors = arrayListOf(Color.Red, Color.Blue),
                    end = Offset(200f, 400f)
                ),
                strokeWidth = 30f,
                cap = StrokeCap.Round
            )

        }

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(bottom = px50toDp.dp)
        ) {
            drawRect(Color.Cyan)

            // 全ての点をつなげる
            drawPoints(
                points = points,
                pointMode = PointMode.Polygon,
                color = Color.Black,
                strokeWidth = 20f,
                cap = StrokeCap.Round,
            )

        }

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            drawRect(Color.Cyan)

            // 全ての点をつなげる
            drawPoints(
                points = points,
                pointMode = PointMode.Polygon,
                color = Color.Black,
                strokeWidth = 20f,
                cap = StrokeCap.Round,
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(50f, 30f)) // 破線にする。
            )

        }


    }


}


@Preview(name = "PIXEL_4", device = Devices.PIXEL_4)
@Composable
fun PreviewDrawPointsCanvasView() {
    DrawPointsCanvasView()
}