package io.technoirlab.rhi.webgpu

import io.technoirlab.rhi.core.WindowHandle
import io.ygdrasil.webgpu.WGPUContext
import io.ygdrasil.webgpu.canvasContextRenderer
import kotlin.js.unsafeCast

internal actual suspend fun createWebGpuContext(window: WindowHandle): WGPUContext {
    val canvasContext = canvasContextRenderer(
        htmlCanvas = window.canvas.unsafeCast(),
        width = window.extent.width.toInt(),
        height = window.extent.height.toInt()
    )
    return canvasContext.wgpuContext
}
