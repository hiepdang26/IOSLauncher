plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.vhmsoft.launcherios26"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.vhmsoft.launcherios26"
        minSdk = 27
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("String", "APPLICATION_ID", "\"com.vhmsoft.launcherios26\"")
        buildConfigField("String", "SENTRY_DSN", "\"\"")
    }

    signingConfigs {
        getByName("debug") {
            enableV1Signing = true
            enableV2Signing = true
        }
    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
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
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(files("libs/e-ui-sdk-s.jar"))
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.viewpager2)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.material)
    implementation("androidx.localbroadcastmanager:localbroadcastmanager:1.1.0")
    implementation("androidx.room:room-runtime:2.8.4")
    ksp("androidx.room:room-compiler:2.8.4")
    implementation("androidx.viewpager:viewpager:1.1.0")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("io.reactivex.rxjava2:rxjava:2.2.21")
    implementation("com.jakewharton.rxbinding3:rxbinding:3.1.0")
    implementation("com.jakewharton.rxrelay2:rxrelay:2.1.1")
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.11.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
    implementation("org.apache.commons:commons-lang3:3.14.0")
    implementation("org.greenrobot:eventbus:3.3.1")
    implementation("me.relex:circleindicator:2.1.6")
    implementation("io.github.hokofly:hoko-blur:1.4.0")
    implementation("com.qmdeve.liquidglass:core:1.0.5")
    implementation("com.jakewharton.timber:timber:5.0.1")
    implementation("androidx.profileinstaller:profileinstaller:1.4.1")
    implementation("foundation.e:elib:0.0.1-alpha11")
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.1.5")
    testImplementation(libs.junit)
    testImplementation("org.json:json:20260522")
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}
