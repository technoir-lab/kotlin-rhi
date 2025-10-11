package io.technoirlab.rhi.core

interface RenderTarget : AutoCloseable {
    val arraySize: Int
    val extent: Extent2D
    val colorFormat: Format
    val textures: List<Texture>
    val depthStencil: Texture?
    val clearValues: ClearValues
}
