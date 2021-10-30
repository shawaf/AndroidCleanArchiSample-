package com.elshawaf.core.extension

import android.content.Context
import android.graphics.Color
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.core.content.res.use

/**
 * Created by Mohamed Elshawaf on 13/7/2021 .
 */
@ColorInt
fun Context.getThemeColor(@AttrRes themeAttrId: Int): Int {
    return obtainStyledAttributes(intArrayOf(themeAttrId)).use {
        it.getColor(0, Color.MAGENTA)
    }
}
