package io.technoirlab.rhi.core

interface Texture : AutoCloseable {
    val extent: Extent2D
    val format: Format
    val sampleCount: UInt
}
