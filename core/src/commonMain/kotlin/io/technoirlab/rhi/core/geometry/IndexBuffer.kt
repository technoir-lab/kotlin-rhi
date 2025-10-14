package io.technoirlab.rhi.core.geometry

import io.technoirlab.rhi.core.Buffer

interface IndexBuffer : Buffer {
    val indexCount: UInt
    val indexType: IndexType
}
