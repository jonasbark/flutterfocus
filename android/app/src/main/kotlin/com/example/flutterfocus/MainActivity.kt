package com.example.flutterfocus

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import io.flutter.embedding.android.FlutterActivity
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory

class MainActivity: FlutterActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.w("TEST", "HALLO")
        flutterEngine!!.platformViewsController
                .registry
                .registerViewFactory("flutter.stripe/card_field", StripeSdkCardPlatformViewFactory())
    }
}

class StripeSdkCardPlatformViewFactory : PlatformViewFactory(StandardMessageCodec.INSTANCE) {

    override fun create(context: Context, viewId: Int, args: Any?): PlatformView {
        context.setTheme(R.style.Theme_AppCompat_Light)
        return StripeSdkCardPlatformView(context)
    }
}


class StripeSdkCardPlatformView(private val context: Context) : PlatformView {


    override fun getView(): View {
        return CardView(context)
    }

    override fun dispose() {
    }

}