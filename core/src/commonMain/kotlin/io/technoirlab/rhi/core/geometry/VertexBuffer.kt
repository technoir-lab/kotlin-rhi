package io.technoirlab.rhi.core.geometry

interface VertexBuffer : AutoCloseable {
    val size: UInt
    val vertexLayout: VertexLayout
}
