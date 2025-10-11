package io.technoirlab.rhi.core

interface RenderTarget : AutoCloseable {
    val arraySize: Int
    val extent: Extent2D
    val colorFormat: Format
    val images: List<Image2D>
    val depthStencil: Image2D?
    val clearValues: ClearValues
}
