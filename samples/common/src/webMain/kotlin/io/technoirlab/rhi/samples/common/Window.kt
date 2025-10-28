package io.technoirlab.rhi.samples.common

import io.technoirlab.rhi.core.WindowHandle
import kotlinx.browser.document
import org.w3c.dom.HTMLCanvasElement

actual class Window : AutoCloseable {
    private val canvas = checkNotNull(document.getElementById("webgpu-canvas")) { "No 'webgpu-canvas' element found!" }

    actual val handle: WindowHandle
        get() = WindowHandle(canvas as HTMLCanvasElement)

    actual override fun close() = Unit
}
