object Dependencies {
    /**
     * To define plugins
     */
    const val androidBuildGradle = "com.android.tools.build:gradle:${Versions.gradlePlugin}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"


    /**
     * To define dependencies
     */

    val kotlinKtx = "androidx.core:core-ktx:${Versions.kotlinKtx}"
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val materialDesign = "com.google.android.material:material:${Versions.material}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    /**
     * DI
     */
    const val daggerHilt="com.google.dagger:hilt-android:${Versions.hilt}"
    const val daggerHiltCompiler="com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val daggerHiltAndXCompiler="androidx.hilt:hilt-compiler:${Versions.hilt_x}"
    const val lifecycle_hilt_viewmodel="androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hilt_x}"


    /**
     * Testing
     */
    val junit = "junit:junit:${Versions.jUnit}"
    val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

}

