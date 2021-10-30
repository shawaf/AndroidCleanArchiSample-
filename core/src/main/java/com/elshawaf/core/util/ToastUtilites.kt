package com.elshawaf.core.util

import android.app.Activity
import android.content.Context
import android.widget.Toast

/**
 * Created by mohamedelshawaf on 1/25/18.
 */
object ToastUtilites {


    fun showToast(activity: Activity, message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

    fun showToast(activity: Context, message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

//    fun showConnectionErrorToast(activity: Context) {
//        Toast.makeText(activity, activity.getString(R.string.connection_error), Toast.LENGTH_LONG).show()
//    }
//
//    fun showTryAgainToast(activity: Context) {
//        Toast.makeText(activity, activity.getString(R.string.failed_try), Toast.LENGTH_LONG).show()
//    }
//
//    fun showCompleteToast(activity: Context) {
//        Toast.makeText(activity, activity.getString(R.string.complete_fields), Toast.LENGTH_LONG).show()
//    }
}