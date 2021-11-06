object Dependencies {
    /**
     * To define plugins
     */
    const val androidBuildGradle = "com.android.tools.build:gradle:${Versions.gradlePlugin}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val daggerHiltPlugin="com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltPlugin}"

    /**
     * To define dependencies
     */

    val kotlinKtx = "androidx.core:core-ktx:${Versions.kotlinKtx}"
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val materialDesign = "com.google.android.material:material:${Versions.material}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    /**
     * DI
     */
    const val daggerHilt="com.google.dagger:hilt-android:${Versions.hilt}"
    const val daggerHiltCompiler="com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val daggerHiltAndXCompiler="androidx.hilt:hilt-compiler:${Versions.hilt_x}"

    /**
     * LifeCycle
     */
    const val lifecycle_hilt_viewmodel="androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hilt_x}"
    const val lifecycle_viewmodel="androidx.lifecycle:lifecycle-viewmodel:${Versions.lifecycle}"
    const val lifecycle_livedata="androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    /**
     * Networking
     */
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofit_gson_converter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit2_version}"
    const val retrofit_rxjavaAdapter = "com.squareup.retrofit2:adapter-rxjava3:${Versions.retrofit}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"

    /**
     * Testing
     */
    val junit = "junit:junit:${Versions.jUnit}"
    val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    /**
     * Utilities
     */
    val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    val json_serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serialization}"
    val glide="com.github.bumptech.glide:glide:${Versions.glide}"

    /**
     * Room
     */
    val roomRuntime= "androidx.room:room-runtime:${Versions.room_version}"
    val roomKtx ="androidx.room:room-ktx:${Versions.room_version}"
    val roomCompiler= "androidx.room:room-compiler:${Versions.room_version}"


}

