package io.technoirlab.rhi.core

import io.technoirlab.rhi.core.geometry.IndexBuffer
import io.technoirlab.rhi.core.geometry.PrimitiveType
import io.technoirlab.rhi.core.geometry.VertexBuffer

interface RenderState : AutoCloseable {
    val vertexBuffer: VertexBuffer
    val indexBuffer: IndexBuffer
    val primitiveType: PrimitiveType
    val vertexShader: Shader
    val fragmentShader: Shader
    val rasterState: RasterState
    val depthStencilState: DepthStencilState
    var pushConstants: ByteArray?
}
