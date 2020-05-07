package com.appnikks.androutils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.annotation.RequiresPermission

/**
 * @author Sahib Singh
 * @since 08/05/20
 * Network Utils Class
 */
object NetworkUtils {

    @Suppress("DEPRECATION")
    @RequiresPermission(value = "android.permission.ACCESS_NETWORK_STATE")
    fun Context.isNetworkConnected(): Boolean {
        val connMgr = this.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo: NetworkInfo? = connMgr.activeNetworkInfo
        return networkInfo?.isConnected == true
    }
}