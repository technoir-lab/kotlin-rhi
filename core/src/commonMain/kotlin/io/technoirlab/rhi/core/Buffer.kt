package io.technoirlab.rhi.core

import kotlinx.io.Source

interface Buffer : AutoCloseable {
    val size: UInt

    fun updateData(source: Source, size: UInt, offset: UInt = 0u)
}
