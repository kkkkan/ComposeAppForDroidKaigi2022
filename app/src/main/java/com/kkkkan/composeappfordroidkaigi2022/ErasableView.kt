package com.kkkkan.composeappfordroidkaigi2022

import android.view.MotionEvent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import java.io.Serializable
import java.lang.Integer.min

// 線を引いた履歴
// Serialize可能にするために、一次ソースとして記憶する時は組み込みのPathクラスではなくこちらを使用する
sealed class PathHis : Serializable {
    abstract val x: Float
    abstract val y: Float


    data class MoveTo(override val x: Float, override val y: Float) : PathHis()
    data class LineTo(override val x: Float = 0f, override val y: Float = 0f) : PathHis()
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ErasableView() {


    // 指でなぞられた軌跡の履歴
    val tracks = rememberSaveable {
        mutableStateOf<List<PathHis>?>(null)
    }


    // なぞられる画像
    val srcImage = ImageBitmap.imageResource(id = R.drawable.dog_mizu_tobasu)

    // 背景におく、透明レイヤー画像
    val bgImage =
        ImageBitmap.imageResource(R.drawable.trans_bg)

    val drawScope = getPaintContent(tracks.value, srcImage, bgImage)

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .pointerInteropFilter { it ->
                // 指でなぞられた軌跡をtracksに記憶していく
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> {
                        // 新しいインスタンスにしないとrecomposeされない
                        tracks.value = ArrayList<PathHis>().apply {
                            tracks.value?.let {
                                addAll(it)
                            }
                            add(PathHis.MoveTo(it.x, it.y))
                        }
                    }
                    MotionEvent.ACTION_MOVE, MotionEvent.ACTION_UP -> {
                        // 新しいインスタンスにしないとrecomposeされない
                        tracks.value = ArrayList<PathHis>().apply {
                            tracks.value?.let {
                                addAll(it)
                            }
                            add(PathHis.LineTo(it.x, it.y))
                        }

                    }
                    else -> false
                }
                true
            },
        onDraw = drawScope
    )


}


/**
 * 実際にCanvasに描く内容
 *
 * @param tracks なぞられた軌跡
 * @param srcImage 画像
 * @param bgImage 背景の透過レイヤー画像
 */
private fun getPaintContent(
    tracks: List<PathHis>?,
    srcImage: ImageBitmap,
    bgImage: ImageBitmap,
): DrawScope.() -> Unit {
    return {

        // PathHisリスト -> Pathリストに変換
        val paths = ArrayList<Path>()
        tracks?.let {
            var path = Path()
            it.forEach { pathHis ->
                when (pathHis) {
                    is PathHis.MoveTo -> {
                        // 今までの編集から飛んだ部分に指をおいたら
                        // 今までの軌跡は終了。記録して、新しい軌跡を始める。
                        paths.add(path)
                        path = Path()
                        path.moveTo(pathHis.x, pathHis.y)
                    }
                    is PathHis.LineTo -> {
                        path.lineTo(pathHis.x, pathHis.y)
                    }
                }

            }

            // 最後の軌跡をリストイン
            paths.add(path)

        }


        // canvasのサイズ
        val canvasWidth = this.size.width
        val canvasHeight = this.size.height


        // 画像のサイズ
        val srcImageBitmapWidth = srcImage.width
        val srcImageBitmapHeight = srcImage.height


        // 画像の縦横比を保ちつつなるべく大きく描くために何倍の縮尺で描くかを決定する
        val scaleWidth = canvasWidth / srcImageBitmapWidth
        val scaleHeight = canvasHeight / srcImageBitmapHeight
        val scale = min(scaleHeight.toInt(), scaleWidth.toInt())

        // 画面に入りきる限り最大限に描いたときの画像の大きさ
        val editSrcWidth = srcImageBitmapWidth * scale
        val editSrcHeight = srcImageBitmapHeight * scale


        // 画面中央に描くために必要なオフセット
        // 各辺、(画面サイズ-描く画像のサイズ)/2
        val offset = Offset((canvasWidth - editSrcWidth) / 2, (canvasHeight - editSrcHeight) / 2)



        inset(horizontal = offset.x, vertical = offset.y) {
            // 上下左右にoffsetを入れる
            // =このスコープでは、座標原点が平行移動された(右と下のcanvasとしての終点もずれた)


            // 背景の透明レイヤー画像を設定
            // 最後にDstOverで同じく透過レイヤー画像を設定するが、
            // それだけでは画像(srcImageBitmap)が背景透過画像だったときにもとからあった透過部分に透過レイヤー画像が表示されない。
            // (alpha 0でも画像は画像だから?)
            // 画像と同じ大きさに描く
            drawImage(
                image = bgImage,
                dstSize = IntSize(editSrcWidth, editSrcHeight)
            )

            // 画像を描く
            drawImage(
                image = srcImage,
                dstSize = IntSize(editSrcWidth, editSrcHeight)
            )


            // 指でなぞった軌跡の太さ(単位 : pixel)
            val transStroke = 40f


            // canvasに対して軌跡をDstOutで描く
            // DstOut : 描かれる側(背景側)のうち、今から描く側(今回の場合はpath)と重なっていないところだけ表示。「描く側」の方は一切描かない。
            // 現在のDrawScopeの領域をはみ出した部分は描写しないためにclipRectを使用。
            clipRect {
                inset(-offset.x, -offset.y) {
                    // 指で描いた軌跡(paths)は、canvasにとっての座標で記録が取れているはずなのでcanvasの大きさで作る
                    // そのために打ち消す方向にinsetを入れる
                    paths.forEach { path ->
                        drawPath(
                            path = path,
                            color = Color.Red,// 最終的に透明レイヤー画像にするので何色でも関係ないが、透明だと反応しない。
                            style = Stroke(width = transStroke), // デフォルトはFill=線で囲まれた領域を埋めてしまう。今回は線通りに描く。太さは40f pixel。
                            blendMode = BlendMode.DstOut,
                        )
                    }
                }
            }


            // それだと、せっかく設定してあった背景まで切り取られてしまうので、改めてDstOverで透明レイヤー画像を描く。
            // DstOver : 描かれ側を描く側の上に重ねて描写
            if (tracks != null) {
                drawImage(
                    image = bgImage,
                    dstSize = IntSize(
                        editSrcWidth,
                        editSrcHeight
                    ),// 一番最初に背景透過を描き込んだ時と同じサイズで描くので、前面画像が背景透過画像だった場合も格子がずれることはない
                    blendMode = BlendMode.DstOver
                )
            }


            val lastTouch = tracks?.lastOrNull()
            if (lastTouch != null) {
                // 触っているところに●を書く(編集の補助になるように)
                // 描写領域外だった場合は描かない
                clipRect {
                    // i現在のスコープからはみ出した部分は切り取る
                    inset(-offset.x, -offset.y) {
                        // lastTouchはcanvasに対した座標で記録されているはずなので
                        // 先ほど入れたinsetを打ち消すinsetを入れてやる
                        drawCircle(
                            color = Color.Red,
                            center = Offset(
                                x = lastTouch.x,
                                y = lastTouch.y
                            ),
                            radius = transStroke / 2,
                            style = Stroke(width = transStroke / 4)
                        )
                    }
                }
            }


        }


    }

}


@Preview(name = "PIXEL_4", device = Devices.PIXEL_4)
@Composable
fun PreviewErasableView() {
    ErasableView()
}