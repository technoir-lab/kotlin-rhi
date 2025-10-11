package io.technoirlab.rhi.core

import org.w3c.dom.HTMLCanvasElement

actual class WindowHandle(val canvas: HTMLCanvasElement) {
    actual val extent: Extent2D
        get() = Extent2D(canvas.width.toUInt(), canvas.height.toUInt())
}
