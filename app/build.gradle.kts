plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.example.redditnews"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.redditnews"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    implementation(libs.androidx.datastore.preferences)

    implementation("io.coil-kt.coil3:coil-network-okhttp:3.0.4") // Only available on Android/JVM.
    implementation("io.coil-kt.coil3:coil-compose:3.2.0")

    // JSON serialization library, works with the Kotlin serialization plugin.
    implementation(libs.kotlinx.serialization.json)

    // Compose Navigation
    api(libs.androidx.navigation.compose)
    // retrofit
    api(libs.retrofit)
    implementation(libs.converter.gson)

    // okhttp3
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)

    //hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    api(libs.androidx.hilt.navigation.compose)

    //room
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)

    // If this project uses any Kotlin source, use Kotlin Symbol Processing (KSP)
    // See Add the KSP plugin to your project
    ksp(libs.androidx.room.compiler)

    //room
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)

    // If this project uses any Kotlin source, use Kotlin Symbol Processing (KSP)
    // See Add the KSP plugin to your project
    ksp(libs.androidx.room.compiler)


    // testing
    testImplementation(libs.hamcrest.all)
    testImplementation(libs.androidx.core.testing)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.truth)
    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.inline)

    testImplementation(libs.turbine)
    testImplementation(libs.junit)

    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.kotlin)


    // AndroidX Test - Instrumented testing
    androidTestImplementation(libs.androidx.junit.ktx)
    androidTestImplementation(libs.androidx.room.testing)
    androidTestImplementation(libs.androidx.core.testing)
    androidTestImplementation(libs.androidx.espresso.contrib)
    androidTestImplementation(libs.androidx.espresso.intents)
    androidTestImplementation(libs.androidx.idling.concurrent)
    androidTestImplementation(libs.androidx.junit)
}