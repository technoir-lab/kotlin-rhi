package io.technoirlab.rhi.mock.geometry

import io.technoirlab.rhi.core.geometry.VertexBuffer
import io.technoirlab.rhi.core.geometry.VertexLayout

internal class MockVertexBuffer(
    override val size: UInt,
    override val vertexLayout: VertexLayout
) : VertexBuffer {
    override fun close() = Unit
}
