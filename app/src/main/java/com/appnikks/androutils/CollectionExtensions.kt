package com.appnikks.androutils

/**
 * @author Sahib Singh
 * @since 08/05/20
 * Collections Utils Class
 */

object CollectionExtensions {

    inline fun <reified T> tryCast(instance: Any?, block: T.() -> Unit) {
        if (instance is T) {
            block(instance)
        }
    }

}