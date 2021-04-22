package com.example.flutterfocus

import android.content.Context
import android.widget.FrameLayout
import com.stripe.android.view.CardInputWidget

class CardView(context: Context) : FrameLayout(context) {
  private var mCardWidget: CardInputWidget

  init {
    mCardWidget = CardInputWidget(context);
    addView(mCardWidget)

    viewTreeObserver.addOnGlobalLayoutListener { requestLayout() }
  }

  override fun requestLayout() {
    super.requestLayout()
    post(mLayoutRunnable)
  }

  private val mLayoutRunnable = Runnable {
    measure(
      MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY),
      MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY))
    layout(left, top, right, bottom)
  }
}
