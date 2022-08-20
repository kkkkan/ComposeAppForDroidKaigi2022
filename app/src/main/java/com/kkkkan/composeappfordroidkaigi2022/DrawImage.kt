package com.kkkkan.composeappfordroidkaigi2022

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

@Composable
fun DrawImageCanvasView() {
    val px50toDp = 50f / LocalContext.current.resources.displayMetrics.density
    val image = ImageBitmap.imageResource(id = R.drawable.dog_mizu_tobasu)
    Column(
        modifier = Modifier
            .padding(px50toDp.dp)
            .fillMaxSize()
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(bottom = px50toDp.dp)
        ) {
            drawRect(Color.Cyan)
            drawImage(
                image = image,
            )

        }
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            drawRect(Color.Cyan)
            drawImage(
                image = image,
                srcOffset = IntOffset(50, 50),
                srcSize = IntSize((image.width - 50 - 50), (image.height - 50 - 50))
            )
            drawImage(
                image = image,
                dstOffset = IntOffset(0, image.height),
                dstSize = IntSize(300, 100)
            )

            drawImage(
                image = image,
                topLeft = Offset(image.width.toFloat(), 0f),
            )
        }
    }

}


@Preview(name = "PIXEL_4", device = Devices.PIXEL_4)
@Composable
fun PreviewDrawImageCanvasView() {
    DrawImageCanvasView()
}