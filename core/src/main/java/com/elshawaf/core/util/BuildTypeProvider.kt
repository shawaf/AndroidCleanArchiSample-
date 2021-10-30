package com.elshawaf.core.util

import com.elshawaf.core.BuildConfig
import javax.inject.Inject

/**
 * Instead of accessing the build type directly in the classes we will use this provider so in testing
 * We can easily mock its result to assert different behaviors in a unit test.
 * Created by Mohamed Elshawaf on 13/7/2021.
 */
class BuildTypeProvider @Inject constructor() {

    fun isDebugBuild() = BuildConfig.DEBUG
}
