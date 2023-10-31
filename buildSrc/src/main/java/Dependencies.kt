object Dependencies {
    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val lifecycle_runtime_ktx by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle_runtime_ktx}" }
    val activity_compose by lazy { "androidx.activity:activity-compose:${Versions.activity_compose}" }
    val compose_bom by lazy { "androidx.compose:compose-bom:${Versions.compose_bom}" }
    val ui by lazy { "androidx.compose.ui:ui" }
    val ui_graphics by lazy { "androidx.compose.ui:ui-graphics" }
    val ui_tooling_preview by lazy { "androidx.compose.ui:ui-tooling-preview" }
    val material3 by lazy { "androidx.compose.material3:material3" }
    val junit by lazy { "junit:junit:${Versions.junit}" }
    val androidx_junit by lazy { "androidx.test.ext:junit:${Versions.androidx_junit}" }
    val espresso_core by lazy { "androidx.test.espresso:espresso-core:${Versions.espresso_core}" }
    val androidx_compose_bom by lazy { "androidx.compose:compose-bom:${Versions.androidx_compose_bom}" }
    val ui_test_junit4 by lazy { "androidx.compose.ui:ui-test-junit4" }
    val ui_tooling by lazy { "androidx.compose.ui:ui-tooling" }
    val ui_test_manifest by lazy { "androidx.compose.ui:ui-test-manifest" }
    val lifecycle_viewmodel_ktx by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_version}" }
    val lifecycle_viewmodel_compose by lazy { "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycle_version}" }
    val appcompat by lazy { "androidx.appcompat:appcompat:${Versions.appcompat}" }

    val hiltAndroid by lazy { "com.google.dagger:hilt-android:${Versions.hiltAndroid}" }
    val hiltAndroidCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hiltAndroidCompiler}" }
    val hiltCompiler by lazy { "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}" }
    val hiltNavigationCompose by lazy { "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}" }

    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val okhttp by lazy { "com.squareup.okhttp:okhttp:${Versions.okhttp}" }
    val gsonConverter by lazy { "com.squareup.retrofit2:converter-gson:${Versions.gsonConverter}" }
    val moshi by lazy { "com.squareup.moshi:moshi-kotlin:${Versions.moshi}" }
    val moshiConverter by lazy { "com.squareup.retrofit2:converter-moshi:${Versions.moshiConverter}" }
    val loggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}" }

    val coroutinesCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}" }
    val coroutinesAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}" }

    val splashScreen by lazy { "androidx.core:core-splashscreen:${Versions.splashScreen}" }

    val coil by lazy { "io.coil-kt:coil:${Versions.coil}" }
}

object Modules {
    const val utilities = ":utilities"
}