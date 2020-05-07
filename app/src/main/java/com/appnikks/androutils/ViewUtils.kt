package com.appnikks.androutils

import android.view.View

/**
 * @author Sahib Singh
 * @since 08/05/20
 * View Utils Class
 */

object ViewUtils {
    fun View.gone() {
        if (this.visibility != View.GONE) {
            this.visibility = View.GONE
        }
    }

    fun View.invisible() {
        if (this.visibility != View.INVISIBLE) {
            this.visibility = View.INVISIBLE
        }
    }

    fun View.visible() {
        if (this.visibility != View.VISIBLE) {
            this.visibility = View.VISIBLE
        }
    }

    fun View.isVisible(): Boolean {
        return this.visibility == View.VISIBLE
    }
}