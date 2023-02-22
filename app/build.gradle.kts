import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("plugin.parcelize")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.ray.language"
    compileSdk = libs.versions.sdk.compile.get().toInt()

    defaultConfig {
        applicationId = "com.ray.language"
        minSdk = libs.versions.sdk.min.get().toInt()
        targetSdk = libs.versions.sdk.target.get().toInt()
        versionCode = libs.versions.app.versioncode.get().toInt()
        versionName = libs.versions.app.versionname.get()

        buildConfigField("String", "MUSIX_MATCH_API_KEY", getLocalProperty("musixmatch_api_key"))
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        debug {
            isMinifyEnabled = false
            isShrinkResources = false
            isDebuggable = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            applicationIdSuffix = ".debug"
        }
    }
    /**
     * Gradle 7.0.0 이상에서는 JDK 11 을 기본으로 사용한다.
     * url : https://cliearl.github.io/posts/android/android-gradle-java-11/
     */
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":design"))

    implementation(libs.bundles.kotlin)
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    implementation(libs.bundles.androidx.data)
    implementation(libs.bundles.network)

    implementation(libs.timber)
    implementation(libs.leakcanary)
    debugImplementation(libs.bundles.flipper)

    implementation(libs.bundles.androidx.presentation)
    implementation(libs.google.material)
    implementation(libs.glide)
    kapt(libs.glide.compiler)
}

fun getLocalProperty(propertyKey: String): String {
    return gradleLocalProperties(rootDir).getProperty(propertyKey)
}
