package com.elshawaf.core.extension

import android.view.View
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar

/**
 * Created by Mohamed Elshawaf on 12/7/2021
 */
fun shortSnackbar(container: View, @StringRes textRes: Int) {
    Snackbar.make(container, textRes, Snackbar.LENGTH_SHORT).show()
}
