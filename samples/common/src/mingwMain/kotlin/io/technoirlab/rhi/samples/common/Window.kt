package io.technoirlab.rhi.samples.common

import io.technoirlab.rhi.core.WindowHandle

actual class Window : AutoCloseable {
    actual val handle: WindowHandle
        get() = TODO("Not yet implemented")

    actual override fun close() = Unit
}
