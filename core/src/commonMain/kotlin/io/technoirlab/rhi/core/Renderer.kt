package io.technoirlab.rhi.core

import io.technoirlab.rhi.core.config.RendererConfig

interface Renderer : AutoCloseable {
    fun createDevice(window: WindowHandle, config: RendererConfig): Device

    fun prepare(): FrameState

    fun present(frameState: FrameState)

    fun render(frameState: FrameState, renderState: RenderState)

    fun reset()
}
