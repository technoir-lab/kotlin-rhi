package io.technoirlab.rhi.core

import kotlinx.io.Source

interface Buffer : AutoCloseable {
    val size: ULong

    fun updateData(source: Source, size: ULong = this.size, offset: ULong = 0uL)
}
