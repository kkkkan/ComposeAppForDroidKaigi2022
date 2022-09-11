package com.kkkkan.composeappfordroidkaigi2022

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            // 黒背景に白い対角線のCanvas
//            SimpleCanvasView()

            // ピンクの矩形+黄色い矩形に黒い対角線のCanvas
            OverAreaCanvasView()

            // drawArc の例
//            DrawArcCanvasView()

            // drawCircle の例
//            DrawCircleCanvasView()

            // drawImage の例
//            DrawImageCanvasView()

            // drawLine の例
//            DrawLineCanvasView()

            // drawOval の例
//            DrawOvalCanvasView()

            // drawPath の例
//            DrawPathCanvasView()

            // drawPoints の例
//            DrawPointsCanvasView()

            // drawRect の例
//            DrawRectCanvasView()

            // drawRoundRect の例
//            DrawRoundRectCanvasView()

            // clipRect の例
//            ClipRectCanvasView()

            // inset の例
//            InsetCanvasView()

            // 「中央に犬の画像があり、その上を指でなぞると軌跡が透明レイヤーの画像になる」コンポーネント
            ErasableView()
        }
    }


    /**
     * 黒背景に白い対角線のCanvas
     */
    @Composable
    fun SimpleCanvasView() {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawRect(Color.Black)
            inset(150.0f) {
                drawLine(
                    color = Color.White,
                    start = Offset.Zero,
                    end = Offset(size.width, size.height),
                    strokeWidth = 10.0f
                )
            }
        }
    }

    @Preview
    @Composable
    fun PreviewSimpleCanvasView() {
        SimpleCanvasView()
    }


    /**
     * ピンクの矩形+黄色い矩形に黒い対角線のCanvas
     */
    @Composable
    fun OverAreaCanvasView() {
        val px50toDp = 50f / LocalContext.current.resources.displayMetrics.density
        Canvas(
            modifier = Modifier
                .padding(px50toDp.dp)
                .fillMaxSize()
        ) {
            drawRect(Color.Magenta)
            inset(150.0f) {
                drawRect(Color.Yellow)
                drawLine(
                    color = Color.Black,
                    start = Offset(-150f - 50f, -150f - 50f),
                    end = Offset(size.width + 150f + 50f, size.height + 150f + 50f),
                    strokeWidth = 40.0f
                )
            }
        }
    }


    @Preview(name = "PIXEL_4", device = Devices.PIXEL_4)
    @Composable
    fun PreviewOverAreaCanvasView() {
        OverAreaCanvasView()
    }

}

