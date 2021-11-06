package com.elshawaf.androidcleanarchsample.utils

import android.app.Activity
import android.graphics.Color
import android.view.View
import com.google.android.material.snackbar.Snackbar

object CommonUsed {

    fun showSnackBar(activity: Activity, message: String, action: String? = null,
                     actionListener: View.OnClickListener? = null, duration: Int = Snackbar.LENGTH_SHORT) {
        val snackBar = Snackbar.make(activity.findViewById(android.R.id.content), message, duration)
            .setBackgroundTint(Color.parseColor("#FFBB86FC")) // todo update your color
            .setTextColor(Color.WHITE)
        if (action != null && actionListener!=null) {
            snackBar.setAction(action, actionListener)
        }
        snackBar.show()
    }
}