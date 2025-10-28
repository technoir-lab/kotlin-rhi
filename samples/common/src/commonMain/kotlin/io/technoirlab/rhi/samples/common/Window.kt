package io.technoirlab.rhi.samples.common

import io.technoirlab.rhi.core.WindowHandle

expect class Window() : AutoCloseable {
    val handle: WindowHandle

    override fun close()
}
