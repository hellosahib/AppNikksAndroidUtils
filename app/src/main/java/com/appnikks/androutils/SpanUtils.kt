package com.appnikks.androutils

import android.text.SpannableString
import android.text.style.UnderlineSpan

object SpanUtils {
    /**
     * Used to Add Underline to Text
     */
    fun String.underLine(): CharSequence {
        val content = SpannableString(this)
        content.setSpan(UnderlineSpan(), 0, content.length, 0)
        return content
    }
}