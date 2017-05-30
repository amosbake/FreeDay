package mopel.io.freeday.helper

import android.content.res.Resources


/**
 * Author: mopel
 * Date : 2017/5/29
 * usage : 88.px/sp/px
 */
val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()
val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()
val Int.sp:Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()