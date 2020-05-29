package com.appnikks.androutils

import android.graphics.BlurMaskFilter
import android.view.View
import android.widget.TextView

object TextViewUtils {

    /**
     * Used to Blur An TextView
     */
    fun TextView.blur() {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        val radius: Float = textSize / 3
        val filter = BlurMaskFilter(radius, BlurMaskFilter.Blur.NORMAL)
        paint.maskFilter = filter
    }

    fun TextView.removeBlur() {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        paint.maskFilter = null
    }

}