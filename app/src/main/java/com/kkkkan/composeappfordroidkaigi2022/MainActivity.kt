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
            OverAreaCanvasView()
        }
    }


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




    @Composable
    fun OverAreaCanvasView() {
        val px50toDp= 50f/LocalContext.current.resources.displayMetrics.density
        Canvas(modifier = Modifier
            .padding(px50toDp.dp)
            .fillMaxSize()) {
            drawRect(Color.Cyan)
            inset(150.0f) {
                drawRect(Color.Yellow)
                drawLine(
                    color = Color.Black,
                    start = Offset(-150f-50f, -150f-50f),
                    end = Offset(size.width+150f+50f, size.height+150f+50f),
                    strokeWidth = 10.0f
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

