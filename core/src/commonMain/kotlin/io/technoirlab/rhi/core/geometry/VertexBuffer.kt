package io.technoirlab.rhi.core.geometry

import io.technoirlab.rhi.core.Buffer

interface VertexBuffer : Buffer {
    val vertexCount: UInt
    val vertexLayout: VertexLayout
}
