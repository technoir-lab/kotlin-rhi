package io.technoirlab.rhi.mock.geometry

import io.technoirlab.rhi.core.geometry.IndexBuffer
import io.technoirlab.rhi.core.geometry.IndexType

internal class MockIndexBuffer(
    override val size: UInt,
    override val indexType: IndexType
) : IndexBuffer {
    override fun close() = Unit
}
