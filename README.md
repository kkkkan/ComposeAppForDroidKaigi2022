# ComposeAppForDroidKaigi2022
DroidKaigi2022 プロジェクト発表資料内に出てきたコードのプロジェクトです。

[発表時のスライド](https://speakerdeck.com/kkkkan/droidkaigi2022-jetpack-composewoyong-ite-canvaswozhi-jie-hong-ruyounakonponentowozuo-cheng-surufang-fa-1)

<img src="https://user-images.githubusercontent.com/22609306/189529131-1e2b6c9e-611c-44ad-874d-5fb83820e8df.png" width="40%"></img>



# スライド内のpreviewとこのプロジェクト内のファイルの対応

|メソッド名(あれば)|説明|preview|プロジェクト内ファイル|
|--|--|--|--|
|-|黒背景に白い対角線のCanvas|<img src="https://user-images.githubusercontent.com/22609306/189527560-03c65021-3c29-45e2-9fb0-c977836851f2.png" height="250px"></img>|[MainActivity.ktのSimpleCanvasView()メソッド](https://github.com/kkkkan/ComposeAppForDroidKaigi2022/blob/master/app/src/main/java/com/kkkkan/composeappfordroidkaigi2022/MainActivity.kt#L72)|
|-|ピンクの矩形+黄色い矩形に黒い対角線のCanvas|<img src="https://user-images.githubusercontent.com/22609306/189527485-8a7cbc17-9ee2-4ce4-a399-f4ed4112080a.png" height="250px"></img>|[MainActivity.ktのOverAreaCanvasView()メソッド](https://github.com/kkkkan/ComposeAppForDroidKaigi2022/blob/master/app/src/main/java/com/kkkkan/composeappfordroidkaigi2022/MainActivity.kt#L98)|
|drawArc|円弧を描く|<img src="https://user-images.githubusercontent.com/22609306/189528576-1bd1327e-d145-4c33-b8cb-78d5e8eab1b4.png" height="250px"></img>|[DrawArc.kt](https://github.com/kkkkan/ComposeAppForDroidKaigi2022/blob/master/app/src/main/java/com/kkkkan/composeappfordroidkaigi2022/DrawArc.kt)|
|drawCircle|正円を描く|<img src="https://user-images.githubusercontent.com/22609306/189528558-ded0fc76-7b08-4492-935b-1e755bc08e61.png" height="250px"></img>|[DrawCircle.kt](https://github.com/kkkkan/ComposeAppForDroidKaigi2022/blob/master/app/src/main/java/com/kkkkan/composeappfordroidkaigi2022/DrawCircle.kt)|
|drawImage|画像を描く|<img src="https://user-images.githubusercontent.com/22609306/189528525-702ef820-f550-4e6b-a7d2-ffa5f89de9b2.png" height="250px"></img>|[DrawImage.kt](https://github.com/kkkkan/ComposeAppForDroidKaigi2022/blob/master/app/src/main/java/com/kkkkan/composeappfordroidkaigi2022/DrawImage.kt)|
|drawLine|直線を描く|<img src="https://user-images.githubusercontent.com/22609306/189528616-d05fc762-4855-4ec2-a4f3-34629cb69c67.png" height="250px"></img>|[DrawLine.kt](https://github.com/kkkkan/ComposeAppForDroidKaigi2022/blob/master/app/src/main/java/com/kkkkan/composeappfordroidkaigi2022/DrawLine.kt)|
|drawOval|楕円を描く|<img src="https://user-images.githubusercontent.com/22609306/189528641-4c00104b-6e01-4cce-8133-4d0aef9e447e.png" height="250px"></img>|[DrawOval.kt](https://github.com/kkkkan/ComposeAppForDroidKaigi2022/blob/master/app/src/main/java/com/kkkkan/composeappfordroidkaigi2022/DrawOval.kt)|
|drawPath|線を描く|<img src="https://user-images.githubusercontent.com/22609306/189527786-09149a38-43ac-4ad6-be97-052ef659d0df.png" height="250px"></img>|[DrawPath.kt](https://github.com/kkkkan/ComposeAppForDroidKaigi2022/blob/master/app/src/main/java/com/kkkkan/composeappfordroidkaigi2022/DrawPath.kt)|
|drawPoints|点を描写する|<img src="https://user-images.githubusercontent.com/22609306/189527832-3e2438f6-3399-4875-9401-a8f8fd118f27.png" height="250px"></img>|[DrawPoints.kt](https://github.com/kkkkan/ComposeAppForDroidKaigi2022/blob/master/app/src/main/java/com/kkkkan/composeappfordroidkaigi2022/DrawPoints.kt)|
|drawRect|矩形を描く|<img src="https://user-images.githubusercontent.com/22609306/189527882-102833f9-f4e7-4db2-b9bb-29ea857bd970.png" height="250px"></img>|[DrawRect.kt](https://github.com/kkkkan/ComposeAppForDroidKaigi2022/blob/master/app/src/main/java/com/kkkkan/composeappfordroidkaigi2022/DrawRect.kt)|
|drawRoundRect|角の丸い矩形を描く|<img src="https://user-images.githubusercontent.com/22609306/189527962-7557e285-ce0c-4748-b057-a8e9febd3282.png" height="250px"></img>|[DrawRoundRect.kt](https://github.com/kkkkan/ComposeAppForDroidKaigi2022/blob/master/app/src/main/java/com/kkkkan/composeappfordroidkaigi2022/DrawRoundRect.kt)|
|clipRect|指定矩形外に描写出来ないようにする|<img src="https://user-images.githubusercontent.com/22609306/189528082-5e6170db-a518-48f9-9ea7-797f10789bc4.png" height="250px"></img>|[ClipRect.kt](https://github.com/kkkkan/ComposeAppForDroidKaigi2022/blob/master/app/src/main/java/com/kkkkan/composeappfordroidkaigi2022/ClipRect.kt)|
|inset|座標空間を移動し、描画領域䛾寸法を変更する|<img src="https://user-images.githubusercontent.com/22609306/189528158-b1d5c829-7ac1-41b2-b61e-473c14b06335.png" height="250px"></img>|[Inset.kt](https://github.com/kkkkan/ComposeAppForDroidKaigi2022/blob/master/app/src/main/java/com/kkkkan/composeappfordroidkaigi2022/Inset.kt)|
|-|「中央に犬の画像があり、その上を指でなぞると軌跡が透明レイヤーの画像になる」コンポーネント|<img src="https://user-images.githubusercontent.com/22609306/189554085-b59a426f-62a2-476f-ac96-8654cfbc468d.png" height="250px"></img>|[ErasableView.kt](https://github.com/kkkkan/ComposeAppForDroidKaigi2022/blob/master/app/src/main/java/com/kkkkan/composeappfordroidkaigi2022/ErasableView.kt)|

