plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.newsdemo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.newsdemo"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.lifecycle_runtime_ktx)
    implementation(Dependencies.activity_compose)
    implementation(platform(Dependencies.compose_bom))
    implementation(Dependencies.ui)
    implementation(Dependencies.ui_graphics)
    implementation(Dependencies.ui_tooling_preview)
    implementation(Dependencies.material3)
    implementation(Dependencies.lifecycle_viewmodel_ktx)
    implementation(Dependencies.lifecycle_viewmodel_compose)
    implementation(project(Modules.utilities))
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.ui_test_junit4)
    androidTestImplementation(Dependencies.espresso_core)
    androidTestImplementation(platform(Dependencies.androidx_compose_bom))
    androidTestImplementation(Dependencies.androidx_junit)
    debugImplementation(Dependencies.ui_tooling)
    debugImplementation(Dependencies.ui_test_manifest)

    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)
    kapt(Dependencies.hiltAndroidCompiler)
    implementation(Dependencies.hiltNavigationCompose)

    implementation(Dependencies.retrofit)
    implementation(Dependencies.okhttp)
    implementation(Dependencies.gsonConverter)
    implementation(Dependencies.moshi)
    implementation(Dependencies.moshiConverter)
    implementation(Dependencies.loggingInterceptor)

    implementation(Dependencies.coroutinesCore)
    implementation(Dependencies.coroutinesAndroid)

    implementation(Dependencies.splashScreen)

    implementation(Dependencies.coil)
}

kapt {
    correctErrorTypes = true
}