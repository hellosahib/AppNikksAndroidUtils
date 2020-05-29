package com.appnikks.androutils

/**
 * @author Sahib Singh
 * @since 13/03/20
 * An Custom Implementation For Analytics
 * @sample
 *
 * class AnalyticsLogger(context: Context) : IEventTracker {
 * private val trackersList = mutableListOf<IEventTracker>()
 * init {
 * trackersList.add(FirebaseAnalyticsTracker(context.applicationContext))
 * }
 * fun trackEvent(event: TTEvent) {
 * trackersList.forEach {
 * it.trackEvent(event)
 * }
 * }
 *
 **/

/**
 * Used To Create Trackers For Every Analytic Platform
 */
abstract class AbstractEventTracker<T> : IEventTracker {

    /**
     * Sends the Raw AnalyticEvent for Tracking
     * @param event Event To Be Tracked
     */
    override fun trackEvent(event: AnalyticEvent) {
        if (isInterestedEvent(event.funnel)) {
            postEvent(transformEvent(event))
        }
    }


    abstract fun isInterestedEvent(funnel: AnalyticsFunnelModel): Boolean
    abstract fun transformEvent(event: AnalyticEvent): T
    abstract fun postEvent(transformedTTEvent: T)
    abstract override fun addUserProperty(vararg property: UserPropertyAnalyticsModel)
    abstract override fun onAppClosed()
}

open class AnalyticEvent(val name: String, val funnel: AnalyticsFunnelModel = AnalyticsFunnelModel()) {

    private val _params = mutableMapOf<String, Any>()

    val params: Map<String, Any>
        get() = _params

    fun addValue(key: String, value: Any) {
        _params[key] = value
    }
}

open class AnalyticsFunnelModel

data class UserPropertyAnalyticsModel(val key: String, val value: Any)

interface IEventTracker {
    fun trackEvent(event: AnalyticEvent)
    fun addUserProperty(vararg property: UserPropertyAnalyticsModel)
    fun onAppClosed()
    fun onUserSignedIn(trackingId: String, userEmail: String, userName: String?)
    fun onUserLoggedOut()
}