package io.technoirlab.rhi.samples.common

import io.technoirlab.rhi.core.WindowHandle

actual class Window : AutoCloseable {
    actual val handle: WindowHandle = WindowHandle()

    actual override fun close() = Unit
}
