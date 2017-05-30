package mopel.io.freeday.helper

import android.content.Context
import android.content.SharedPreferences


/**
 * Author: mopel
 * Date : 2017/5/29
 */
class Prefs(context: Context) {
    val PREFS_FILENAME = "freeDay.prefs"
    val LOGIN_TOKEN = "login_token"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0)

    var login: Boolean
        get() = prefs.getBoolean(LOGIN_TOKEN, false)
        set(value) = prefs.edit().putBoolean(LOGIN_TOKEN, value).apply()
}