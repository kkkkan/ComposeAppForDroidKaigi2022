package com.kkkkan.composeappfordroidkaigi2022

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SimpleCanvasView()
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

}

