package io.technoirlab.rhi.webgpu

import io.technoirlab.rhi.core.Device
import io.technoirlab.rhi.core.FrameState
import io.technoirlab.rhi.core.GraphicsState
import io.technoirlab.rhi.core.Renderer
import io.technoirlab.rhi.core.WindowHandle
import io.technoirlab.rhi.core.config.RendererConfig

class WebGpuRenderer : Renderer {
    override fun createDevice(
        window: WindowHandle,
        config: RendererConfig
    ): Device = WebGpuDevice()

    override fun prepare(): FrameState = WebGpuFrameState()

    override fun present(frameState: FrameState) = Unit

    override fun render(frameState: FrameState, graphicsState: GraphicsState) = Unit

    override fun reset() = Unit

    override fun close() = Unit
}
