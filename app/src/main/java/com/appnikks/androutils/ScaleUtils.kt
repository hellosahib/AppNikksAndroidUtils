package com.appnikks.androutils

import android.content.Context
import android.util.TypedValue
import androidx.annotation.Dimension
import androidx.annotation.Px

/**
 * @author Sahib Singh
 * @since 08/05/20
 * Scale Utils Class
 */
object ScaleUtils {

    /**
     * Converts DP To PX
     */
    @Px
    fun Context.dpToPx(@Dimension(unit = Dimension.DP) dp: Float): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics)
    }
}