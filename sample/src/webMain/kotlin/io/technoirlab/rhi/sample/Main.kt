package io.technoirlab.rhi.sample

import io.technoirlab.rhi.core.WindowHandle
import kotlinx.browser.document
import org.w3c.dom.HTMLCanvasElement

fun main() {
    val canvas = checkNotNull(document.getElementById("webgpu-canvas")) { "No 'webgpu-canvas' element found!" }
    WindowHandle(canvas as HTMLCanvasElement)
}
