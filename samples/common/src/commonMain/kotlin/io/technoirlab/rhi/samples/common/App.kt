package io.technoirlab.rhi.samples.common

import io.github.oshai.kotlinlogging.KotlinLogging
import kotlin.concurrent.Volatile

class App {
    private val logger = KotlinLogging.logger { }

    @Volatile
    private var terminated: Boolean = false

    val window: Window by lazy { Window() }

    fun run(callback: AppCallback) = window.use {
        try {
            callback.onLaunch()
        } catch (@Suppress("TooGenericExceptionCaught") e: Exception) {
            terminated = true
            logger.error(e) { "Failed to launch application" }
            return
        }

        while (!terminated) {
            callback.onRender()
        }

        callback.onTerminate()
    }
}
