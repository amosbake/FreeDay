package mopel.io.freeday.helper

import android.content.Context
import android.preference.PreferenceManager
import kotlin.reflect.KProperty


/**
 * Author: mopel
 * Date : 2017/5/29
 * ref : http://czerwinski.it/2017/05/17/delegating-android-shared-preferences-in-kotlin.html
 */
class StringPrefDelegate(
        context: Context,
        private val key: String,
        private val defaultValue: String = ""
) {
    private val sharePreference by lazy {
        PreferenceManager.getDefaultSharedPreferences(context)
    }

    operator fun getValue(ref: Any?, property: KProperty<*>): String =
            sharePreference.getString(key, defaultValue)

    operator fun setValue(ref: Any?, property: KProperty<*>, value: String):Unit {
        sharePreference.edit()
                .putString(key, value)
                .apply()
    }
}