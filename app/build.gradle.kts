@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.application)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.com.apollographql.apollo3)
}

android {
    namespace = "com.example.jetpack_glance_sample"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.jetpack_glance_sample"
        minSdk = 34
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
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField(
                "String",
                "GITHUB_ACCESS_TOKEN",
                "${properties["GITHUB_ACCESS_TOKEN"]}"
            )
        }
        debug {
            buildConfigField(
                "String",
                "GITHUB_ACCESS_TOKEN",
                "${properties["GITHUB_ACCESS_TOKEN"]}"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
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

    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.lifecycle.runtime.compose)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)

    //glance app widget
    implementation(libs.androidx.glance.appwidget)
    implementation(libs.androidx.glance.material3)

    //apollo3
    implementation(libs.com.apollographql.apollo3.runtime)

    //kotlinx-datetime
    implementation(libs.kotlinx.datetime)

    //koin for android
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)

}

apollo {
    service("service") {
        packageName.set("com.example.jetpack_glance_sample")
    }
}