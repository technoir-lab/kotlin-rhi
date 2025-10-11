package io.technoirlab.rhi.core.geometry

interface IndexBuffer : AutoCloseable {
    val size: UInt
    val indexType: IndexType
}
