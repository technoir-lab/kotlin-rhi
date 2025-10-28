@file:OptIn(ExperimentalWasmDsl::class)

import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    id("io.technoirlab.conventions.kotlin-multiplatform-library")
}

kotlinMultiplatformLibrary {
    packageName = "io.technoirlab.rhi.samples.common"
}

kotlin {
    linuxArm64()
    linuxX64()
    macosArm64()
    mingwX64()
    js {
        browser()
    }
    wasmJs {
        browser()
    }

    sourceSets {
        commonMain.dependencies {
            api(project(":core"))
            api(libs.kotlin.logging)
        }
        nativeMain.dependencies {
            implementation(project(":backend:vulkan"))
            implementation(libs.glfw.native)
        }
        webMain.dependencies {
            implementation(project(":backend:webgpu"))
            implementation(libs.kotlinx.browser)
        }
    }
}
