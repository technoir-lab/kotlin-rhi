package io.technoirlab.rhi.webgpu

import io.technoirlab.rhi.core.Device
import io.technoirlab.rhi.core.FrameState
import io.technoirlab.rhi.core.GraphicsState
import io.technoirlab.rhi.core.Renderer
import io.technoirlab.rhi.core.WindowHandle
import io.technoirlab.rhi.core.config.RendererConfig

class WebGpuRenderer : Renderer {
    override suspend fun createDevice(
        window: WindowHandle,
        config: RendererConfig
    ): Device {
        val context = createWebGpuContext(window)
        return WebGpuDevice(context)
    }

    override fun prepare(): FrameState {
        return WebGpuFrameState()
    }

    override fun present(frameState: FrameState) {
        require(frameState is WebGpuFrameState)
    }

    override fun render(frameState: FrameState, graphicsState: GraphicsState) {
        require(frameState is WebGpuFrameState)
        require(graphicsState is WebGpuGraphicsState)
    }

    override fun reset() = Unit

    override fun close() = Unit
}
