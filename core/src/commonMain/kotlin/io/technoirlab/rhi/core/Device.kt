package io.technoirlab.rhi.core

import io.technoirlab.rhi.core.geometry.IndexBuffer
import io.technoirlab.rhi.core.geometry.IndexType
import io.technoirlab.rhi.core.geometry.PrimitiveType
import io.technoirlab.rhi.core.geometry.VertexBuffer
import io.technoirlab.rhi.core.geometry.VertexLayout
import kotlinx.io.Source

interface Device : AutoCloseable {
    fun createDepthStencilBuffer(extent: Extent2D, format: Format): Image2D

    fun createVertexBuffer(source: Source, size: UInt, vertexLayout: VertexLayout): VertexBuffer

    fun createIndexBuffer(source: Source, size: UInt, indexType: IndexType): IndexBuffer

    fun loadShader(source: Source): Shader

    @Suppress("LongParameterList")
    fun createRenderState(
        renderTarget: RenderTarget,
        vertexBuffer: VertexBuffer,
        indexBuffer: IndexBuffer,
        primitiveType: PrimitiveType,
        vertexShader: Shader,
        fragmentShader: Shader,
        pushConstants: ByteArray? = null
    ): RenderState
}
