package io.technoirlab.rhi.mock

import io.technoirlab.rhi.core.DepthStencilState
import io.technoirlab.rhi.core.Device
import io.technoirlab.rhi.core.Extent2D
import io.technoirlab.rhi.core.Format
import io.technoirlab.rhi.core.RasterState
import io.technoirlab.rhi.core.RenderState
import io.technoirlab.rhi.core.RenderTarget
import io.technoirlab.rhi.core.Shader
import io.technoirlab.rhi.core.Texture
import io.technoirlab.rhi.core.geometry.IndexBuffer
import io.technoirlab.rhi.core.geometry.IndexType
import io.technoirlab.rhi.core.geometry.PrimitiveType
import io.technoirlab.rhi.core.geometry.VertexBuffer
import io.technoirlab.rhi.core.geometry.VertexLayout
import kotlinx.io.Source

class MockDevice : Device {
    override fun createDepthStencilBuffer(
        extent: Extent2D,
        format: Format
    ): Texture {
        TODO("Not yet implemented")
    }

    override fun createVertexBuffer(
        source: Source,
        size: UInt,
        vertexLayout: VertexLayout
    ): VertexBuffer {
        TODO("Not yet implemented")
    }

    override fun createIndexBuffer(
        source: Source,
        size: UInt,
        indexType: IndexType
    ): IndexBuffer {
        TODO("Not yet implemented")
    }

    override fun loadShader(source: Source): Shader = MockShader()

    override fun createRenderState(
        renderTarget: RenderTarget,
        vertexBuffer: VertexBuffer,
        indexBuffer: IndexBuffer,
        primitiveType: PrimitiveType,
        vertexShader: Shader,
        fragmentShader: Shader,
        rasterState: RasterState,
        depthStencilState: DepthStencilState,
        pushConstants: ByteArray?
    ): RenderState {
        TODO("Not yet implemented")
    }

    override fun close() = Unit
}
