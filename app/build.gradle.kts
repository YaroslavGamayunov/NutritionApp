plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdkVersion(Versions.COMPILE_SDK)
    buildToolsVersion = Versions.BUILD_TOOLS

    defaultConfig {
        applicationId = "com.yaroslavgamayunov.nutritionapp"
        minSdkVersion(Versions.MIN_SDK)
        targetSdkVersion(Versions.TARGET_SDK)
        versionCode(Versions.VERSION_CODE)
        versionName(Versions.VERSION_NAME)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
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
}

dependencies {
    // Kotlin
    implementation(KotlinDependencies.STDLIB)
    implementation(KotlinDependencies.CORE_KTX)

    // Android
    implementation(AndroidDependencies.APPCOMPAT)
    implementation(AndroidDependencies.MATERIAL)
    implementation(AndroidDependencies.CONSTRAINT_LAYOUT)

    // Testing
    testImplementation(TestingDependencies.JUNIT)
    androidTestImplementation(TestingDependencies.JUNIT_EXT)
    androidTestImplementation(TestingDependencies.ESPRESSO_CORE)
}

tasks.register("checkStatic") {
    group = "Verify"
    description = "Runs static checks on the build"
    dependsOn("detekt")
}