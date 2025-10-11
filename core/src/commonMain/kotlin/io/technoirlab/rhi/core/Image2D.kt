package io.technoirlab.rhi.core

interface Image2D : AutoCloseable {
    val extent: Extent2D
    val format: Format
    val sampleCount: UInt
}
