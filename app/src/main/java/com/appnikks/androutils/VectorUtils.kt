package com.appnikks.androutils

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.Nullable
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat

/**
 * @author Sahib Singh
 * @since 08/05/20
 * Vector Utils Class
 */
object VectorUtils {

    /**
     * It Gets The Drawable using Vector Drawable Compat
     * If Drawable is not found it returns null
     */
    @Nullable
    fun Context.getDrawableCompat(@DrawableRes resID: Int): Drawable? = VectorDrawableCompat.create(resources, resID, null)

    /**
     * It Gets The Coloured Drawable and Tint it using @param colorRes
     * If Drawable is not found it returns null
     */
    @Nullable
    fun Context.getColouredDrawableCompat(@DrawableRes drawableRes: Int, @ColorRes colorRes: Int): Drawable? {
        val mDrawable = ContextCompat.getDrawable(this, drawableRes) ?: return null
        var mWrappedDrawable: Drawable = mDrawable.mutate()
        mWrappedDrawable = DrawableCompat.wrap(mWrappedDrawable)
        DrawableCompat.setTint(mWrappedDrawable, ResourcesCompat.getColor(resources, colorRes, theme))
        DrawableCompat.setTintMode(mWrappedDrawable, PorterDuff.Mode.SRC_IN)
        return mWrappedDrawable
    }
}