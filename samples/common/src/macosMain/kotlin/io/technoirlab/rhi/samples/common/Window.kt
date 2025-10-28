package io.technoirlab.rhi.samples.common

import io.technoirlab.rhi.core.WindowHandle
import platform.QuartzCore.CAMetalLayer

actual class Window : AutoCloseable {
    private val layer = CAMetalLayer()

    actual val handle: WindowHandle
        get() = WindowHandle(layer)

    actual override fun close() = Unit
}
