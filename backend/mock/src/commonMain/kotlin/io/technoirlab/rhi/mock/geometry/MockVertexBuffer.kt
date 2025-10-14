package io.technoirlab.rhi.mock.geometry

import io.technoirlab.rhi.core.geometry.VertexBuffer
import io.technoirlab.rhi.core.geometry.VertexLayout
import io.technoirlab.rhi.mock.MockBuffer

internal class MockVertexBuffer(
    size: UInt,
    override val vertexCount: UInt,
    override val vertexLayout: VertexLayout
) : MockBuffer(size), VertexBuffer
